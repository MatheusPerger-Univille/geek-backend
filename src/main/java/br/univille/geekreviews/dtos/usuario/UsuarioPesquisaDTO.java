package br.univille.geekreviews.dtos.usuario;

import br.univille.geekreviews.domain.enums.Permissao;
import br.univille.geekreviews.dtos.AbstractDTO;

import java.util.Calendar;

public class UsuarioPesquisaDTO extends AbstractDTO {

    private String nome;

    private Permissao permissao;

    private String permissaoDesc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public String getPermissaoDesc() {
        return permissao.getDescricaoNome();
    }

    public void setPermissaoDesc(String permissaoDesc) {
        this.permissaoDesc = permissaoDesc;
    }
}
