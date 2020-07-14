package br.univille.geekreviews.dtos.filme;

import br.univille.geekreviews.dtos.MidiaDTO;

import javax.validation.constraints.NotNull;

public class FilmeDTO extends MidiaDTO {

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
}
