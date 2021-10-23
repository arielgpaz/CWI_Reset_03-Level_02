package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> getPet() {
        return petService.listarTodosPets();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getByName(@PathVariable String nome) throws PetNaoExistenteException {
        return ResponseEntity.ok(petService.buscarPeloNome(nome));
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetJaExistenteException {
        return petService.salvar(pet);
    }

    @PutMapping
    public Pet atualizarPet(@RequestBody Pet pet) throws PetNaoExistenteException {
        return petService.atualizar(pet);
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetNaoExistenteException {
            petService.deletar(nome);
    }

}
