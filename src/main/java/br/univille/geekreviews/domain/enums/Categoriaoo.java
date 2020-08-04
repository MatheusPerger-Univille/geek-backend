package br.univille.geekreviews.domain.enums;

import br.univille.geekreviews.services.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public enum Categoriaoo {

    PS4(0, "ps4"), XBOXONE(1, "xbox-one"), SWITCH(2, "switch"),
    AVENTURA(3, "aventura"), ACAO(4, "acao"), SUSPENSE(5, "suspense"),
    TERROR(6, "terror"), DRAMA(7, "drama"), ROMANCE(8, "romance"),
    COMPUTACAO(9, "computacao"), FANTASIA(10, "fantasia"), HORROR(11, "horror"),
    FICCAO(12, "ficcao");

    private int codigo;

    private String descricao;

    Categoriaoo(int codigo) {
        this.codigo = codigo;
    }

    Categoriaoo(String descricao) {
        this.descricao = descricao;
    }

    Categoriaoo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoriaoo getByCodigo(int codigo) {
        for (Categoriaoo cat : Categoriaoo.values()) {
            if (cat.getCodigo() == codigo)
                return cat;
        }

        throw new BusinessException("Código inválido de categoria");
    }

    public static Categoriaoo getByDescricao(String descricao) {
        for (Categoriaoo cat : Categoriaoo.values()) {
            if (cat.getDescricao().equals(descricao))
                return cat;
        }

        throw new BusinessException("Descrição invalida de categoria");
    }

    public static List<Categoriaoo> getByDescricaoList(List<String> categorias) {
        List<Categoriaoo> listCat = new ArrayList();

        for (String cat : categorias)
            listCat.add(getByDescricao(cat));

        return listCat;
    }
}
