package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.request.EstudioRequest;
import br.com.cwi.reset.arielgustavo.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody @Valid EstudioRequest estudioRequest) throws InvalidArgumentsExceptions {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam("filtroNome") String filtroNome) throws InvalidArgumentsExceptions {
        return estudioService.listarEstudio(filtroNome);
    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return estudioService.consultarEstudio(id);
    }

}
