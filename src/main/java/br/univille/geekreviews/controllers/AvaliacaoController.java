package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.services.avaliacao.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/avaliacoes", produces = MediaType.APPLICATION_JSON_VALUE)
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR', 'USUARIO')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@RequestBody AvaliacaoDTO dto) {

        this.service.salvar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR', 'USUARIO')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@RequestBody AvaliacaoDTO dto) {

        this.service.atualizar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }
}
