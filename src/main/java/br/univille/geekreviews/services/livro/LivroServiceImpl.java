package br.univille.geekreviews.services.livro;

import br.univille.geekreviews.domain.Livro;
import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import br.univille.geekreviews.mappers.LivroMapper;
import br.univille.geekreviews.repositories.LivroRepository;
import br.univille.geekreviews.services.S3Service;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@Service
@Transactional
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository repo;

    @Autowired
    private LivroMapper mapper;

    @Autowired
    private S3Service s3Service;

    @Override
    public LivroDTO obterPorId(Long id) {

        Livro entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<LivroPesquisaDTO> filtrar(String search, Pageable p) {

        Page<Livro> livros = repo.filtrar(search, p);
        Page<LivroPesquisaDTO> dtos = livros.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public Long salvar(LivroDTO dto) {

        Livro entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        Livro livro = repo.save(entity);
        return livro.getId();
    }

    @Override
    public Long atualizar(LivroDTO dto) {

        Livro entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        Livro livro = repo.save(entity);
        return livro.getId();
    }

    @Override
    public void excluir(Long id) {

        Livro entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    private void validarInsercaoAtualizacao(LivroDTO dto) throws BusinessException {

        Livro livro = repo.findByTitulo(dto.getTitulo());

        if (livro == null)
            return;

        if (dto.isEdicao() && (livro.getId() == dto.getId()))
            return;

        throw new BusinessException("O livro " + dto.getTitulo() + " já está cadastrado.");
    }

    @Override
    public void uploadImagem(MultipartFile multipartFile, Long idMidia) {

        Livro entity = repo.findById(idMidia).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));

        if (entity.getUrlCapa() != null)
            s3Service.deleteFile(entity.getUrlCapa());

        URI urlImagem = s3Service.uploadFile(multipartFile);
        entity.setUrlCapa(urlImagem.toString());
        repo.save(entity);
    }
}
