package br.univille.geekreviews.services.game;

import br.univille.geekreviews.dtos.game.GameDTO;
import br.univille.geekreviews.dtos.game.GamePesquisaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GameService {

    GameDTO obterPorId(Long id);

    Page<GamePesquisaDTO> filtrar(String search, Pageable pageable);

    void salvar(GameDTO dto);

    void atualizar(GameDTO dto);

    void excluir(Long id);

    List<PlataformaDTO> obterPlataformasGame(Long idGame);
}
