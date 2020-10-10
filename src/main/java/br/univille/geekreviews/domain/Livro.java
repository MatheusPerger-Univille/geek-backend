package br.univille.geekreviews.domain;

import br.univille.geekreviews.core.domain.Midia;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@DynamicUpdate
public class Livro extends Midia {

    private String autor;

    private String editora;

    private int numeroPaginas;

    private BigDecimal peso;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private List<Categoria> categorias;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livro", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livro", cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, orphanRemoval = true)
    private List<Comentario> comentarios;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
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
