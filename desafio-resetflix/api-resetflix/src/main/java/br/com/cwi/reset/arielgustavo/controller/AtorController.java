package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import br.com.cwi.reset.arielgustavo.response.AtorEmAtividade;
import br.com.cwi.reset.arielgustavo.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    //demais métodos

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody @Valid AtorRequest atorRequest) throws InvalidArgumentsExceptions {
        this.atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam("filtroNome") String filtroNome) throws InvalidArgumentsExceptions {
        List<Ator> atores = atorService.listarAtoresEmAtividade(filtroNome);
        List<AtorEmAtividade> atorEmAtividade = new ArrayList<>();
        for (Ator ator : atores) {
            atorEmAtividade.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
        }
        return atorEmAtividade;
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws InvalidArgumentsExceptions {
        return atorService.consultarAtores();
    }


}
