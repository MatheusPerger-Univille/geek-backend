package br.univille.geekreviews.dtos;

import br.univille.geekreviews.core.domain.TipoMidia;

public class BuscaResumidaFiltroDTO {

    private String termo;
    private TipoMidia tipoMidia;
    private Long categoria;

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public TipoMidia getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(TipoMidia tipoMidia) {
        this.tipoMidia = tipoMidia;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public boolean hasTipoMidia() {
        return tipoMidia != null;
    }

    public boolean hasCategoria() {
        return categoria != null;
    }
}
