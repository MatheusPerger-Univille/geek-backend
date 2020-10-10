package br.univille.geekreviews.services.serie;

import br.univille.geekreviews.dtos.serie.SerieDTO;
import br.univille.geekreviews.dtos.serie.SeriePesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SerieService {

    SerieDTO obterPorId(Long id);

    Page<SeriePesquisaDTO> filtrar(String search, Pageable pageable);

    void salvar(SerieDTO dto);

    void atualizar(SerieDTO dto);

    void excluir(Long id);
}
