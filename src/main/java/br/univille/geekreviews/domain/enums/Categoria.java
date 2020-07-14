package br.univille.geekreviews.domain.enums;

import br.univille.geekreviews.services.exception.BusinessException;

import java.util.ArrayList;
import java.util.List;

public enum Categoria {

    PS4(0, "ps4"), XBOXONE(1, "xbox-one"), SWITCH(2, "switch"),
    AVENTURA(3, "aventura"), ACAO(4, "acao"), SUSPENSE(5, "suspense"),
    TERROR(6, "terror"), DRAMA(7, "drama"), ROMANCE(8, "romance"),
    COMPUTACAO(9, "computacao"), FANTASIA(10, "fantasia"), HORROR(11, "horror"),
    FICCAO(12, "ficcao");

    private int codigo;

    private String descricao;

    Categoria(int codigo) {
        this.codigo = codigo;
    }

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    Categoria(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria getByCodigo(int codigo) {
        for (Categoria cat : Categoria.values()) {
            if (cat.getCodigo() == codigo)
                return cat;
        }

        throw new BusinessException("Código inválido de categoria");
    }

    public static Categoria getByDescricao(String descricao) {
        for (Categoria cat : Categoria.values()) {
            if (cat.getDescricao().equals(descricao))
                return cat;
        }

        throw new BusinessException("Descrição invalida de categoria");
    }

    public static List<Categoria> getByDescricaoList(List<String> categorias) {
        List<Categoria> listCat = new ArrayList();

        for (String cat : categorias)
            listCat.add(getByDescricao(cat));

        return listCat;
    }
}
