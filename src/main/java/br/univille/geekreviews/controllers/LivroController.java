package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import br.univille.geekreviews.services.livro.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/livros", produces = MediaType.APPLICATION_JSON_VALUE)
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<LivroDTO> obterPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPorId(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<LivroPesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> salvar(@Valid @RequestBody LivroDTO dto) {

        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> atualizar(@Valid @RequestBody LivroDTO dto) {

        return new ResponseEntity<>(this.service.atualizar(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/upload/{id}")
    public void upload(@RequestParam(name = "file") MultipartFile file, @PathVariable("id") Long idLivro) {

        this.service.uploadImagem(file, idLivro);
    }
}
