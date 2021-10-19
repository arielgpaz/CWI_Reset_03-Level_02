package br.com.cwi.reset.arielgustavo.controller;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.request.EstudioRequest;
import br.com.cwi.reset.arielgustavo.service.EstudioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    private EstudioService estudioService;

    public EstudioController() {
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    @PostMapping
    public void criarEstudio(EstudioRequest estudioRequest) throws InvalidArgumentsExceptions {
        this.estudioService.criarEstudio(estudioRequest);
    }

//    @GetMapping
//    public List<Estudio> consultarEstudios(String filtroNome) {
//        return null;
//    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws InvalidArgumentsExceptions {
        return estudioService.consultarEstudio(id);
    }

}
