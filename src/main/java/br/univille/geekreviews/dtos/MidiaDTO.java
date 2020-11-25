package br.univille.geekreviews.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MidiaDTO extends AbstractDTO {

    @NotNull(message = "Data lançamento nulo")
    private Calendar dataLancamento;

    @NotNull(message = "Tipo de mídia nulo")
    private String tipo;

    @NotNull(message = "Descrição nulo")
    private String descricao;

    private String urlCapa;

    private MultipartFile arquivoImagem;

    @NotNull(message = "Titulo nulo")
    private String titulo;

    @NotNull(message = "Categorias nulo")
    private List<CategoriaDTO> categorias;

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlCapa() {
        return urlCapa;
    }

    public void setUrlCapa(String urlCapa) {
        this.urlCapa = urlCapa;
    }

    public MultipartFile getArquivoImagem() {
        return arquivoImagem;
    }

    public void setArquivoImagem(MultipartFile arquivoImagem) {
        this.arquivoImagem = arquivoImagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEdicao() {
        return this.getId() != null;
    }

    public List<CategoriaDTO> getCategorias() {
        if (categorias == null)
            categorias = new ArrayList<>();

        return categorias;
    }

    public void setCategorias(List<CategoriaDTO> categorias) {
        this.categorias = categorias;
    }
}
