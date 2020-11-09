package br.univille.geekreviews.dtos.livro;

import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.dtos.ComentarioDTO;
import br.univille.geekreviews.dtos.MidiaDTO;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LivroDTO extends MidiaDTO {

    @NotNull(message = "Direção nulo")
    private String autor;

    private String editora;

    private int numeroPaginas;

    private BigDecimal peso;

    private List<AvaliacaoDTO> avaliacoes;

    private List<ComentarioDTO> comentarios;

    private int notaMidia;

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

    public List<AvaliacaoDTO> getAvaliacoes() {

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getNotaMidia() {
        return notaMidia;
    }

    public void setNotaMidia(int notaMidia) {
        this.notaMidia = notaMidia;
    }

    public List<ComentarioDTO> getComentarios() {

        if (comentarios == null)
            comentarios = new ArrayList<ComentarioDTO>();

        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
