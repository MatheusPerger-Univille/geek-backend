package br.univille.geekreviews.dtos;

public class AvaliacaoDTO extends AbstractDTO {

    private Long userId;

    private String userName;

    private Integer nota;

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
}
