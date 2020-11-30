package br.univille.geekreviews.services.buscaresumida;


import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.domain.Game;
import br.univille.geekreviews.domain.Livro;
import br.univille.geekreviews.domain.Serie;
import br.univille.geekreviews.dtos.BuscaResumidaDTO;
import br.univille.geekreviews.dtos.BuscaResumidaFiltroDTO;
import br.univille.geekreviews.mappers.BuscaResumidaMapper;
import br.univille.geekreviews.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscaResumidaServiceImpl implements BuscaResumidaService {

    private final String PALAVRA_CHAVE_FILME = "filmes";
    private final String PALAVRA_CHAVE_SERIE = "series";
    private final String PALAVRA_CHAVE_GAME = "games";
    private final String PALAVRA_CHAVE_LIVROS = "livros";

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private BuscaResumidaMapper mapper;

    @Override
    public BuscaResumidaDTO obterPesquisaResumida(BuscaResumidaFiltroDTO filtro) {

        List<Filme> filmes = new ArrayList<>();
        List<Serie> series = new ArrayList<>();
        List<Livro> livros = new ArrayList<>();
        List<Game> games = new ArrayList<>();

        String termo = filtro.getTermo().toLowerCase();

        boolean termoChave = termo.equals(PALAVRA_CHAVE_FILME) || termo.equals(PALAVRA_CHAVE_SERIE)
                || termo.equals(PALAVRA_CHAVE_GAME) || termo.equals(PALAVRA_CHAVE_LIVROS);

        if (termoChave) {
            switch (termo) {
                case PALAVRA_CHAVE_FILME:
                    filmes.addAll(filmeRepository.findAll());
                    break;
                case PALAVRA_CHAVE_SERIE:
                    series.addAll(serieRepository.findAll());
                    break;
                case PALAVRA_CHAVE_GAME:
                    games.addAll(gameRepository.findAll());
                    break;
                case PALAVRA_CHAVE_LIVROS:
                    livros.addAll(livroRepository.findAll());
                    break;
            }
        } else {
            filmes.addAll(filmeRepository.obterPorTitulo(filtro.getTermo()));
            livros.addAll(livroRepository.obterPorTitulo(filtro.getTermo()));
            games.addAll(gameRepository.obterPorTitulo(filtro.getTermo()));
            series.addAll(serieRepository.obterPorTitulo(filtro.getTermo()));
        }

        BuscaResumidaDTO resultado = new BuscaResumidaDTO();
        resultado.setFilmes(mapper.toDtosFilme(filmes));
        resultado.setSeries(mapper.toDtosSerie(series));
        resultado.setLivros(mapper.toDtosLivro(livros));
        resultado.setGames(mapper.toDtosGame(games));

        return resultado;
    }

}
