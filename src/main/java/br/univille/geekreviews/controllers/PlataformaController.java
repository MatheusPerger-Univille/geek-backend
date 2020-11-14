package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaPesquisaDTO;
import br.univille.geekreviews.services.game.plataforma.PlataformaService;
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
@RequestMapping(value = "/api/plataformas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlataformaController {

    @Autowired
    private PlataformaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlataformaDTO> obterPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<PlataformaPesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@Valid @RequestBody PlataformaDTO dto) {

        this.service.salvar(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@Valid @RequestBody PlataformaDTO dto) {

        this.service.atualizar(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }
}
