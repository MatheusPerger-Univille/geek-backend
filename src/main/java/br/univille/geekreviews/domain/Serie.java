package br.univille.geekreviews.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class Serie extends FilmeSerie {

    private int numeroEpisodios;

    private int numeroTemporadas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private List<Categoria> categorias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serie", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<Avaliacao> avaliacoes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serie", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    private List<Comentario> comentarios;

    public Serie() {
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public List<Avaliacao> getAvaliacoes() {
        if (avaliacoes == null)
            return new ArrayList<Avaliacao>();

        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        List<Avaliacao> avaliacoes = getAvaliacoes();
        avaliacoes.add(avaliacao);
        setAvaliacoes(avaliacoes);
    }

    public int getNotaMidia() {
        int nota = getAvaliacoes().stream().mapToInt(Avaliacao::getNota).sum();
        return getAvaliacoes().size() == 0 ? 0 : nota / getAvaliacoes().size();
    }

    public List<Comentario> getComentarios() {
        if (avaliacoes == null)
            return new ArrayList<Comentario>();

        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public void setComentario(Comentario comentario) {
        List<Comentario> comentarios = getComentarios();
        comentarios.add(comentario);
        setComentarios(comentarios);
    }
}
