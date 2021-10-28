package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Filme;
import br.com.cwi.reset.arielgustavo.request.FilmeRequest;
import br.com.cwi.reset.arielgustavo.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class
FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody @Valid FilmeRequest filmeRequest) throws InvalidArgumentsExceptions {
        filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws InvalidArgumentsExceptions {
        return filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }

    @DeleteMapping("/{id}")
    public void removerFilme(@PathVariable Integer id) {
        filmeService.removerFilme(id);
    }
}
