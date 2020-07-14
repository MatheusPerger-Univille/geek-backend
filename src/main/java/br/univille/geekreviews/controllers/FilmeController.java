package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.filme.FilmeDTO;
import br.univille.geekreviews.dtos.filme.FilmePesquisaDTO;
import br.univille.geekreviews.services.filme.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/filmes", produces = MediaType.APPLICATION_JSON_VALUE)
public class FilmeController {

    @Autowired
    private FilmeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FilmeDTO> obterPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<FilmePesquisaDTO>> filtrar(Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(pageable), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@Valid @RequestBody FilmeDTO dto) {

        this.service.salvar(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@Valid @RequestBody FilmeDTO dto) {

        this.service.atualizar(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }
}
