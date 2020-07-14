package br.univille.geekreviews.services.filme;

import br.univille.geekreviews.dtos.filme.FilmeDTO;
import br.univille.geekreviews.dtos.filme.FilmePesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FilmeService {

    FilmeDTO obterPorId(Long id);

    Page<FilmePesquisaDTO> filtrar(Pageable pageable);

    void salvar(FilmeDTO dto);

    void atualizar(FilmeDTO dto);

    void excluir(Long id);
}
