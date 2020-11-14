package br.univille.geekreviews.services.game.plataforma;

import br.univille.geekreviews.domain.Plataforma;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaPesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlataformaService {

    PlataformaDTO obterPorId(Long id);

    Page<PlataformaPesquisaDTO> filtrar(String search, Pageable pageable);

    void salvar(PlataformaDTO dto);

    void atualizar(PlataformaDTO dto);

    void excluir(Long id);

    List<Plataforma> obterPorIds(List<Long> ids);

    List<PlataformaDTO> obterPorIdsDtos(List<Long> ids);
}
