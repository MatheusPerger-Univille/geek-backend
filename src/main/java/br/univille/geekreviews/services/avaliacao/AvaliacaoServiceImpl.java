package br.univille.geekreviews.services.avaliacao;

import br.univille.geekreviews.core.domain.TipoMidia;
import br.univille.geekreviews.domain.*;
import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.mappers.AvaliacaoMapper;
import br.univille.geekreviews.repositories.*;
import br.univille.geekreviews.services.exception.BusinessException;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private AvaliacaoMapper mapper;

    @Override
    public void salvar(AvaliacaoDTO dto) {

        Avaliacao entity = this.mapper.toEntity(dto);
        this.setarMidia(dto.getTipoMidia(), dto.getIdMidia(), entity);

        this.repo.save(entity);
    }

    @Override
    public void atualizar(AvaliacaoDTO dto) {

        Avaliacao entity = this.mapper.toEntity(dto);
        this.setarMidia(dto.getTipoMidia(), dto.getIdMidia(), entity);

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
