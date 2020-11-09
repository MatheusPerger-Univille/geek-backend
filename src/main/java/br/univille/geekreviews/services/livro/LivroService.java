package br.univille.geekreviews.services.livro;

import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LivroService {

    LivroDTO obterPorId(Long id);

    Page<LivroPesquisaDTO> filtrar(String search, Pageable pageable);

    void salvar(LivroDTO dto);

    void atualizar(LivroDTO dto);

    void excluir(Long id);
}
