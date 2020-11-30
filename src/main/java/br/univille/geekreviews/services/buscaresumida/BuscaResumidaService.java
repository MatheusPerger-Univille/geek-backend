package br.univille.geekreviews.services.buscaresumida;

import br.univille.geekreviews.dtos.BuscaResumidaDTO;
import br.univille.geekreviews.dtos.BuscaResumidaFiltroDTO;

public interface BuscaResumidaService {

    BuscaResumidaDTO obterPesquisaResumida(BuscaResumidaFiltroDTO filtro);
}
