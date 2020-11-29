package br.univille.geekreviews.dtos.usuario;

import br.univille.geekreviews.domain.enums.Permissao;
import br.univille.geekreviews.dtos.AbstractDTO;

import javax.validation.constraints.NotEmpty;

public class UsuarioDTO extends AbstractDTO {

    @NotEmpty(message = "Nome não preenchido!")
    private String nome;

    @NotEmpty(message = "E-mail não preenchido!")
    private String email;

    @NotEmpty(message = "Senha não preenchida!")
    private String senha;

    private String apelido;

    private String UF;

    private String cidade;

    private Permissao permissao;

    private boolean ativo = true;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
