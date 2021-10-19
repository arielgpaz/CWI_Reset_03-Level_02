package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import br.com.cwi.reset.arielgustavo.response.AtorEmAtividade;
import br.com.cwi.reset.arielgustavo.service.AtorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    private AtorService atorService;

    public AtorController() {
        this.atorService = new AtorService(FakeDatabase.getInstance());
    }

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws InvalidArgumentsExceptions {
        this.atorService.criarAtor(atorRequest);
    }

//    @GetMapping("/em_atividade")
//    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws InvalidArgumentsExceptions {
//
//        return null;
//    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws InvalidArgumentsExceptions {
        return atorService.consultarAtores();
    }


}
