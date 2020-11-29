package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.game.GameDTO;
import br.univille.geekreviews.dtos.game.GamePesquisaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import br.univille.geekreviews.services.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/games", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> obterPorId(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/obter-plataformas/{id}")
    public ResponseEntity<List<PlataformaDTO>> obterPlataformasGame(@PathVariable("id") Long id) {

        return new ResponseEntity<>(this.service.obterPlataformasGame(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<GamePesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void salvar(@Valid @RequestBody GameDTO dto) {

        this.service.salvar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void atualizar(@Valid @RequestBody GameDTO dto) {

        this.service.atualizar(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'REDATOR')")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }
}
