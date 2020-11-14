package br.univille.geekreviews.services.game.plataforma;

import br.univille.geekreviews.domain.Plataforma;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaPesquisaDTO;
import br.univille.geekreviews.mappers.PlataformaMapper;
import br.univille.geekreviews.repositories.PlataformaRepository;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlaformaServiceImpl implements PlataformaService {

    @Autowired
    private PlataformaRepository repo;

    @Autowired
    private PlataformaMapper mapper;

    @Override
    public PlataformaDTO obterPorId(Long id) {
        Plataforma entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<PlataformaPesquisaDTO> filtrar(String search, Pageable pageable) {
        Page<Plataforma> plataformas = repo.filtrar(search, pageable);
        Page<PlataformaPesquisaDTO> dtos = plataformas.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public void salvar(PlataformaDTO dto) {
        Plataforma entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void atualizar(PlataformaDTO dto) {
        Plataforma entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);

        repo.save(entity);
    }

    @Override
    public void excluir(Long id) {
        Plataforma entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    @Override
    public List<Plataforma> obterPorIds(List<Long> ids) {

        return repo.findAllById(ids);
    }

    @Override
    public List<PlataformaDTO> obterPorIdsDtos(List<Long> ids) {

        List<Plataforma> plataformas = repo.findAllById(ids);

        if (CollectionUtils.isEmpty(plataformas))
            return new ArrayList<>();

        return mapper.toDtos(plataformas);
    }

    private void validarInsercaoAtualizacao(PlataformaDTO dto) throws BusinessException {

        Plataforma plataforma = repo.findByNome(dto.getNome());

        if (plataforma == null)
            return;

        if (dto.isEdicao() && (plataforma.getId() == dto.getId()))
            return;

        throw new BusinessException("A plataforma " + dto.getNome() + " já está cadastrada.");
    }
}
