package br.univille.geekreviews.dtos.game.plataforma;

import br.univille.geekreviews.dtos.AbstractDTO;

public class PlataformaPesquisaDTO extends AbstractDTO {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
