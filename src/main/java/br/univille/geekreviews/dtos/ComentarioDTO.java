package br.univille.geekreviews.dtos;

import br.univille.geekreviews.core.domain.TipoMidia;

public class ComentarioDTO extends AbstractDTO {

    private Long userId;

    private String userName;

    private String comentario;

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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
