package br.univille.geekreviews.services.filme;

import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.dtos.filme.FilmeDTO;
import br.univille.geekreviews.dtos.filme.FilmePesquisaDTO;
import br.univille.geekreviews.mappers.FilmeMapper;
import br.univille.geekreviews.repositories.FilmeRepository;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository repo;

    @Autowired
    private FilmeMapper mapper;

    @Override
    public FilmeDTO obterPorId(Long id) {

        Filme entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<FilmePesquisaDTO> filtrar(Pageable p) {
        PageRequest pageRequest = PageRequest.of(p.getPageNumber(), p.getPageSize(), p.getSort());
        Page<Filme> filmes = repo.findAll(pageRequest);
        Page<FilmePesquisaDTO> dtos = filmes.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public void salvar(FilmeDTO dto) {

        Filme entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void atualizar(FilmeDTO dto) {

        Filme entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void excluir(Long id) {

        Filme entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    private void validarInsercaoAtualizacao(FilmeDTO dto) throws BusinessException {

        Filme filme = repo.findByTitulo(dto.getTitulo());

        if (filme == null)
            return;

        if (dto.isEdicao() && (filme.getId() == dto.getId()))
            return;

        throw new BusinessException("O filme " + dto.getTitulo() + " já está cadastrado.");
    }

}
