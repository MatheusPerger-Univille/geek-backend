package br.univille.geekreviews.services.serie;

import br.univille.geekreviews.domain.Serie;
import br.univille.geekreviews.dtos.serie.SerieDTO;
import br.univille.geekreviews.dtos.serie.SeriePesquisaDTO;
import br.univille.geekreviews.mappers.SerieMapper;
import br.univille.geekreviews.repositories.SerieRepository;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SerieServiceImpl implements SerieService {

    @Autowired
    private SerieRepository repo;

    @Autowired
    private SerieMapper mapper;

    @Override
    public SerieDTO obterPorId(Long id) {

        Serie entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<SeriePesquisaDTO> filtrar(String search, Pageable p) {

        Page<Serie> series = repo.filtrar(search, p);
        Page<SeriePesquisaDTO> dtos = series.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public void salvar(SerieDTO dto) {

        Serie entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void atualizar(SerieDTO dto) {

        Serie entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void excluir(Long id) {

        Serie entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    private void validarInsercaoAtualizacao(SerieDTO dto) throws BusinessException {

        Serie serie = repo.findByTitulo(dto.getTitulo());

        if (serie == null)
            return;

        if (dto.isEdicao() && (serie.getId() == dto.getId()))
            return;

        throw new BusinessException("Série " + dto.getTitulo() + " já está cadastrado.");
    }

}
