package br.univille.geekreviews.services.serie;

import br.univille.geekreviews.dtos.serie.SerieDTO;
import br.univille.geekreviews.dtos.serie.SeriePesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface SerieService {

    SerieDTO obterPorId(Long id);

    Page<SeriePesquisaDTO> filtrar(String search, Pageable pageable);

    Long salvar(SerieDTO dto);

    Long atualizar(SerieDTO dto);

    void excluir(Long id);

    void uploadImagem(MultipartFile multipartFile, Long idMidia);
}
