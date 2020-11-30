package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.serie.SerieDTO;
import br.univille.geekreviews.dtos.serie.SeriePesquisaDTO;
import br.univille.geekreviews.services.serie.SerieService;
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
@RequestMapping(value = "/api/series", produces = MediaType.APPLICATION_JSON_VALUE)
public class SerieController {

    @Autowired
    private SerieService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SerieDTO> obterPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<SeriePesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> salvar(@Valid @RequestBody SerieDTO dto) {

        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> atualizar(@Valid @RequestBody SerieDTO dto) {

        return new ResponseEntity<>(this.service.atualizar(dto), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/upload/{id}")
    public void upload(@RequestParam(name = "file") MultipartFile file, @PathVariable("id") Long idSerie) {

        this.service.uploadImagem(file, idSerie);
    }
}
