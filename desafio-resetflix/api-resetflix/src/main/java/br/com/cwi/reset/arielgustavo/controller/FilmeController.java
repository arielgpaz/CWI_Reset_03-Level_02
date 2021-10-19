package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Filme;
import br.com.cwi.reset.arielgustavo.request.FilmeRequest;
import br.com.cwi.reset.arielgustavo.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController() {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    @PostMapping
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws InvalidArgumentsExceptions {
        filmeService.criarFilme(filmeRequest);
    }

//    @GetMapping
//    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) {
//
//        return null;
//    }
}
