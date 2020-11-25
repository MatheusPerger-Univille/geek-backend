package br.univille.geekreviews.services.filme;

import br.univille.geekreviews.dtos.filme.FilmeDTO;
import br.univille.geekreviews.dtos.filme.FilmePesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface FilmeService {

    FilmeDTO obterPorId(Long id);

    Page<FilmePesquisaDTO> filtrar(String search, Pageable pageable);

    Long salvar(FilmeDTO dto);

    Long atualizar(FilmeDTO dto);

    void excluir(Long id);

    void uploadImagem(MultipartFile multipartFile, Long idMidia);
}
