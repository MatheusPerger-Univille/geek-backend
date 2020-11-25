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
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Page<FilmePesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> salvar(@Valid @RequestBody FilmeDTO dto) {

        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> atualizar(@Valid @RequestBody FilmeDTO dto) {

        return new ResponseEntity<>(this.service.atualizar(dto), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/upload/{id}")
    public void upload(@RequestParam(name = "file") MultipartFile file, @PathVariable("id") Long idFilme) {

        this.service.uploadImagem(file, idFilme);
    }
}
