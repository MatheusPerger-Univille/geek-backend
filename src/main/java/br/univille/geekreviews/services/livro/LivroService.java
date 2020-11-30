package br.univille.geekreviews.services.livro;

import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface LivroService {

    LivroDTO obterPorId(Long id);

    Page<LivroPesquisaDTO> filtrar(String search, Pageable pageable);

    Long salvar(LivroDTO dto);

    Long atualizar(LivroDTO dto);

    void excluir(Long id);

    void uploadImagem(MultipartFile multipartFile, Long idMidia);
}
