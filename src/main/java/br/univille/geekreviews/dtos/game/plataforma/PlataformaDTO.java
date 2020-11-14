package br.univille.geekreviews.dtos.game.plataforma;

import br.univille.geekreviews.dtos.AbstractDTO;

public class PlataformaDTO extends AbstractDTO {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEdicao() {
        return this.getId() != null;
    }
}
