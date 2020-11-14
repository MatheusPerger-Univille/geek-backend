package br.univille.geekreviews.dtos.game;

import br.univille.geekreviews.dtos.AbstractDTO;

import java.util.Calendar;

public class GamePesquisaDTO extends AbstractDTO {

    private Calendar dataLancamento;

    private String titulo;

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
