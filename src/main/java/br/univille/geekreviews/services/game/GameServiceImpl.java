package br.univille.geekreviews.services.game;

import br.univille.geekreviews.domain.Game;
import br.univille.geekreviews.dtos.game.GameDTO;
import br.univille.geekreviews.dtos.game.GamePesquisaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.mappers.GameMapper;
import br.univille.geekreviews.repositories.GameRepository;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import br.univille.geekreviews.services.game.plataforma.PlataformaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository repo;

    @Autowired
    private GameMapper mapper;

    @Autowired
    private PlataformaService plataformaService;

    @Override
    public GameDTO obterPorId(Long id) {

        Game entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<GamePesquisaDTO> filtrar(String search, Pageable pageable) {

        Page<Game> games = repo.filtrar(search, pageable);
        Page<GamePesquisaDTO> dtos = games.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public void salvar(GameDTO dto) {

        Game entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);
        entity.setPlataformas(plataformaService.obterPorIds(dto.getPlataformas()));

        repo.save(entity);
    }

    @Override
    public void atualizar(GameDTO dto) {

        Game entity = mapper.toEntity(dto);
        this.validarInsercaoAtualizacao(dto);
        entity.setPlataformas(plataformaService.obterPorIds(dto.getPlataformas()));

        repo.save(entity);
    }

    @Override
    public void excluir(Long id) {

        Game entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    @Override
    public List<PlataformaDTO> obterPlataformasGame(Long idGame) {

        GameDTO dto = this.obterPorId(idGame);
        return plataformaService.obterPorIdsDtos(dto.getPlataformas());
    }

    private void validarInsercaoAtualizacao(GameDTO dto) throws BusinessException {

        Game game = repo.findByTitulo(dto.getTitulo());

        if (game == null)
            return;

        if (dto.isEdicao() && (game.getId() == dto.getId()))
            return;

        throw new BusinessException("O game " + dto.getTitulo() + " já está cadastrado.");
    }
}
