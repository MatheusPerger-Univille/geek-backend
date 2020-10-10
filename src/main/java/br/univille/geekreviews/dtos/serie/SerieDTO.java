package br.univille.geekreviews.dtos.serie;

import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.dtos.ComentarioDTO;
import br.univille.geekreviews.dtos.MidiaDTO;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class SerieDTO extends MidiaDTO {

    @NotNull(message = "Número de episódios nulo")
    private int numeroEpisodios;

    @NotNull(message = "Número de temporadas nulo")
    private int numeroTemporadas;

    @NotNull(message = "Direção nulo")
    private String direcao;

    @NotNull(message = "Elenco nulo")
    private String elenco;

    @NotNull(message = "Nascionalidade nulo")
    private String nascionalidade;

    @NotNull(message = "Duração nulo")
    private String duracao;

    @NotNull(message = "Faixa etária nulo")
    private String faixaEtaria;

    private List<AvaliacaoDTO> avaliacoes;

    private List<ComentarioDTO> comentarios;

    private int notaMidia;

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(String nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public List<AvaliacaoDTO> getAvaliacoes() {
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
            return new ArrayList<ComentarioDTO>();

        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
