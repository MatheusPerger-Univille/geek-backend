package br.univille.geekreviews.dtos;

import java.util.ArrayList;
import java.util.List;

public class BuscaResumidaDTO {

    private List<BuscaResumidaMidiaDTO> filmes;
    private List<BuscaResumidaMidiaDTO> series;
    private List<BuscaResumidaMidiaDTO> livros;
    private List<BuscaResumidaMidiaDTO> games;

    public List<BuscaResumidaMidiaDTO> getFilmes() {

        if (filmes == null)
            filmes = new ArrayList<>();

        return filmes;
    }

    public void setFilmes(List<BuscaResumidaMidiaDTO> filmes) {
        this.filmes = filmes;
    }

    public List<BuscaResumidaMidiaDTO> getSeries() {

        if (series == null)
            series = new ArrayList<>();

        return series;
    }

    public void setSeries(List<BuscaResumidaMidiaDTO> series) {
        this.series = series;
    }

    public List<BuscaResumidaMidiaDTO> getLivros() {

        if (livros == null)
            livros = new ArrayList<>();

        return livros;
    }

    public void setLivros(List<BuscaResumidaMidiaDTO> livros) {
        this.livros = livros;
    }

    public List<BuscaResumidaMidiaDTO> getGames() {

        if (games == null)
            games = new ArrayList<>();

        return games;
    }

    public void setGames(List<BuscaResumidaMidiaDTO> games) {
        this.games = games;
    }
}
