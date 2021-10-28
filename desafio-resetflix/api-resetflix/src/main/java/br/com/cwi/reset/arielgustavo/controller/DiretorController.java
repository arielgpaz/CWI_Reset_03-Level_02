package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.request.DiretorRequest;
import br.com.cwi.reset.arielgustavo.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarDiretor(@RequestBody @Valid DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam("filtroNome") String filtroNome) throws InvalidArgumentsExceptions {
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return diretorService.consultarDiretor(id);
    }

    @PutMapping("/{id}")
    public void atualizarDiretor(@PathVariable Integer id, @RequestBody DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {
        diretorService.atualizarDiretor(id, diretorRequest);
    }

    @DeleteMapping("?/{id}")
    public void removerDiretores(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        diretorService.removerDiretor(id);
    }
}
