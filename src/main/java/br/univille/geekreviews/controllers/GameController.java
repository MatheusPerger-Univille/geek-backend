package br.univille.geekreviews.controllers;

import br.univille.geekreviews.dtos.game.GameDTO;
import br.univille.geekreviews.dtos.game.GamePesquisaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.services.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
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

    @GetMapping(value = "/filtrar")
    public ResponseEntity<Page<GamePesquisaDTO>> filtrar(String search, Pageable pageable) {

        return new ResponseEntity<>(this.service.filtrar(search, pageable), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> salvar(@Valid @RequestBody GameDTO dto) {

        return new ResponseEntity<>(this.service.salvar(dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> atualizar(@Valid @RequestBody GameDTO dto) {

        return new ResponseEntity<>(this.service.atualizar(dto), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/{id}")
    public void excluir(@PathVariable("id") Long id) {

        this.service.excluir(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/upload/{id}")
    public void upload(@RequestParam(name = "file") MultipartFile file, @PathVariable("id") Long idGame) {

        this.service.uploadImagem(file, idGame);
    }
}
