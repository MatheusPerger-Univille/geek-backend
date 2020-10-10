package br.univille.geekreviews.domain;

import br.univille.geekreviews.core.domain.EntityBaseRoot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Avaliacao extends EntityBaseRoot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotNull(message = "Usuário nulo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @NotNull(message = "Nota em branco")
    private int nota;

    @ManyToOne
    @JoinColumn(name = "filme_id", referencedColumnName = "id")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "serie_id", referencedColumnName = "id")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "livro_id", referencedColumnName = "id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    public Avaliacao() {
    }

    public Avaliacao(Long id, int nota, Filme filme) {
        this.id = id;
        this.nota = nota;
        this.filme = filme;
    }

    public Avaliacao(Long id, int nota, Serie serie) {
        this.id = id;
        this.nota = nota;
        this.serie = serie;
    }

    public Avaliacao(Long id, Usuario usuario, int nota) {
        this.id = id;
        this.usuario = usuario;
        this.nota = nota;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
