package br.univille.geekreviews.domain;

import br.univille.geekreviews.core.domain.Midia;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class Game extends Midia {

    private String desenvolvedora;

    private boolean opcaoOnline;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Plataforma> plataformas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<Categoria> categorias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "game", cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
    private List<Comentario> comentarios;

    public Game() {
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public boolean isOpcaoOnline() {
        return opcaoOnline;
    }

    public void setOpcaoOnline(boolean opcaoOnline) {
        this.opcaoOnline = opcaoOnline;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
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
