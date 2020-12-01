package br.univille.geekreviews.dtos.usuario;

import br.univille.geekreviews.domain.enums.Permissao;
import br.univille.geekreviews.dtos.AbstractDTO;

public class UsuarioLogadoDTO extends AbstractDTO {

    private String nome;
    private String email;
    private Permissao permissao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public boolean isAdmin() {
        return permissao.equals(Permissao.ADMINISTRADOR);
    }

    public boolean isRedator() {
        return permissao.equals(Permissao.REDATOR);
    }

    public boolean isUsuario() {
        return permissao.equals(Permissao.USUARIO);
    }
}
