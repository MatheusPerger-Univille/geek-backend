package br.univille.geekreviews.dtos;

import br.univille.geekreviews.core.domain.TipoMidia;

public class AvaliacaoDTO extends AbstractDTO {

    private Long userId;

    private String userName;

    private Integer nota;

    private Long idMidia;

    private TipoMidia tipoMidia;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Long getIdMidia() {
        return idMidia;
    }

    public void setIdMidia(Long idMidia) {
        this.idMidia = idMidia;
    }

    public TipoMidia getTipoMidia() {
        return tipoMidia;
    }

    public void setTipoMidia(TipoMidia tipoMidia) {
        this.tipoMidia = tipoMidia;
    }
}
