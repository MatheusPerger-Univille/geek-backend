package br.univille.geekreviews.domain.enums;

public enum Permissao {

    ADMINISTRADOR(1, "ROLE_ADMIN", "Administrador"),
    REDATOR(2, "ROLE_REDATOR", "Redator"),
    USUARIO(3, "ROLE_USUARIO", "Usuario");

    private int codigo;
    private String descricao;
    private String descricaoNome;

    Permissao() {
    }

    Permissao(int codigo) {
        this.codigo = codigo;
    }

    Permissao(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    Permissao(int codigo, String descricao, String descricaoNome) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.descricaoNome = descricaoNome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescricaoNome() {
        return descricaoNome;
    }
}
