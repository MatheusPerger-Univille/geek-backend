package br.univille.geekreviews.domain.enums;

public enum Permissao {

    ADMINISTRADOR(1),
    REDATOR(2),
    USUARIO(3);

    private int codigo;

    Permissao() {
    }

    Permissao(int codigo) {
        this.codigo = codigo;
    }
}
