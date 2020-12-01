package br.univille.geekreviews.services.avaliacao;

import br.univille.geekreviews.core.domain.TipoMidia;
import br.univille.geekreviews.domain.*;
import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.mappers.AvaliacaoMapper;
import br.univille.geekreviews.repositories.*;
import br.univille.geekreviews.security.UserSS;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import com.amazonaws.services.licensemanager.model.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.univille.geekreviews.services.usuario.UsuarioServiceImpl.getUsuarioLogado;

@Service
@Transactional
public class AvaliacaoServiceImpl implements AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repo;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private AvaliacaoMapper mapper;

    @Override
    public void salvar(AvaliacaoDTO dto) {

        UserSS user = getUsuarioLogado();

        if (user == null)
            throw new AuthorizationException("Acesso negado");

        Avaliacao entity = this.mapper.toEntity(dto);
        this.setarMidia(dto.getTipoMidia(), dto.getIdMidia(), entity);
        entity.setUsuario(userRepository.findById(user.getId()).get());

        this.repo.save(entity);
    }

    @Override
    public void atualizar(AvaliacaoDTO dto) {

        UserSS user = getUsuarioLogado();

        if (user == null)
            throw new AuthorizationException("Acesso negado");

        Avaliacao entity = this.mapper.toEntity(dto);
        this.setarMidia(dto.getTipoMidia(), dto.getIdMidia(), entity);
        entity.setUsuario(userRepository.findById(user.getId()).get());

        this.repo.save(entity);
    }

    @Override
    public void excluir(Long id) {

        this.repo.deleteById(id);
    }

    private void setarMidia(TipoMidia tipo, Long idMidia, Avaliacao avaliacao) {

        switch (tipo) {

            case FILME:
                Filme filme = this.filmeRepository.findById(idMidia).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
                avaliacao.setFilme(filme);
                return;
            case SERIE:
                Serie serie = this.serieRepository.findById(idMidia).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
                avaliacao.setSerie(serie);
                return;
            case GAME:
                Game game = this.gameRepository.findById(idMidia).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
                avaliacao.setGame(game);
                return;
            case LIVRO:
                Livro livro = this.livroRepository.findById(idMidia).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
                avaliacao.setLivro(livro);
                return;
            default:
                throw new BusinessException("Tipo não encontrado!");
        }

    }
}
