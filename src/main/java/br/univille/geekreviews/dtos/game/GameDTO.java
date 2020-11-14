package br.univille.geekreviews.dtos.game;

import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.dtos.ComentarioDTO;
import br.univille.geekreviews.dtos.MidiaDTO;

import java.util.ArrayList;
import java.util.List;

public class GameDTO extends MidiaDTO {

    private String desenvolvedora;

    private boolean opcaoOnline;

    private List<Long> plataformas;

    private List<AvaliacaoDTO> avaliacoes;

    private List<ComentarioDTO> comentarios;

    private int notaMidia;

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public boolean isOpcaoOnline() {
        return opcaoOnline;
    }

    public void setOpcaoOnline(boolean opcaoOnline) {
        this.opcaoOnline = opcaoOnline;
    }

    public List<Long> getPlataformas() {
        if (plataformas == null)
            plataformas = new ArrayList<>();

        return plataformas;
    }

    public void setPlataformas(List<Long> plataformas) {
        this.plataformas = plataformas;
    }

    public List<AvaliacaoDTO> getAvaliacoes() {

        if (avaliacoes == null)
            avaliacoes = new ArrayList<>();
        return avaliacoes;
    }

    public void setAvaliacoes(List<AvaliacaoDTO> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public int getNotaMidia() {
        return notaMidia;
    }

    public void setNotaMidia(int notaMidia) {
        this.notaMidia = notaMidia;
    }

    public List<ComentarioDTO> getComentarios() {

        if (comentarios == null)
            comentarios = new ArrayList<ComentarioDTO>();

        return comentarios;
    }

    public void setComentarios(List<ComentarioDTO> comentarios) {
        this.comentarios = comentarios;
    }
}
