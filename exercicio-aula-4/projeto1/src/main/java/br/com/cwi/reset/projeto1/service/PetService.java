package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<Pet> listarTodosPets () {
        return petRepository.findAll();
    }

    public Pet buscarPeloNome(String nome) throws PetNaoExistenteException {
        Pet pet = petRepository.findByNomeIgnoringCase(nome);
        if (pet == null) {
            throw new PetNaoExistenteException(String.format("O pet com o nome %s não existe.", nome));
        }
        return pet;
    }

    public Pet salvar(Pet pet) throws PetJaExistenteException {
        Pet petJaExistente = petRepository.findByNomeIgnoringCase(pet.getNome());

        if (petJaExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }
        return petRepository.save(pet);
    }

    public void deletar(String nome) throws PetNaoExistenteException {
        Pet petJaExistente = buscarPeloNome(nome);
        if (petJaExistente == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }
        petRepository.delete(petJaExistente);
    }

    public Pet atualizar(Pet pet) throws PetNaoExistenteException {
        Pet petJaExistente = buscarPeloNome(pet.getNome());
        if (petJaExistente == null) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }
        if(!petRepository.existsById(pet.getId())) {
            throw new PetNaoExistenteException("Pet com o id " + pet.getId() + " não existe");
        }

        return petRepository.save(pet);
    }
}
