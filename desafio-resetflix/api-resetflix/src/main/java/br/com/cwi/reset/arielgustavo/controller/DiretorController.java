package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import br.com.cwi.reset.arielgustavo.request.DiretorRequest;
import br.com.cwi.reset.arielgustavo.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDiretor(@RequestBody DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

//    @GetMapping
//    public List<Diretor> listarDiretores( String filtroNome) {
//
//        return null;
//    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return diretorService.consultarDiretor(id);
    }
}
