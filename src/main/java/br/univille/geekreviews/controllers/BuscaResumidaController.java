package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.BuscaResumidaDTO;
import br.univille.geekreviews.dtos.BuscaResumidaFiltroDTO;
import br.univille.geekreviews.services.buscaresumida.BuscaResumidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/busca-resumida", produces = MediaType.APPLICATION_JSON_VALUE)
public class BuscaResumidaController {

    @Autowired
    private BuscaResumidaService service;

    @GetMapping
    public ResponseEntity<BuscaResumidaDTO> obterPesquisaResumida(BuscaResumidaFiltroDTO filtro) {

        return new ResponseEntity<>(this.service.obterPesquisaResumida(filtro), HttpStatus.OK);
    }
}
