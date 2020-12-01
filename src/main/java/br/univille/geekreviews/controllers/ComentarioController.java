package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.ComentarioDTO;
import br.univille.geekreviews.services.comentario.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comentarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR', 'USUARIO')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@RequestBody ComentarioDTO dto) {

        this.service.salvar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR', 'USUARIO')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@RequestBody ComentarioDTO dto) {

        this.service.atualizar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }
}
