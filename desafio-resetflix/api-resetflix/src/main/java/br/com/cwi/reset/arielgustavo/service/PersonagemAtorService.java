package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.PersonagemAtor;
import br.com.cwi.reset.arielgustavo.repository.AtorRepository;
import br.com.cwi.reset.arielgustavo.repository.PersonagemAtorRepository;
import br.com.cwi.reset.arielgustavo.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemAtorService {

    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    @Autowired
    private AtorRepository atorRepository;

    public PersonagemAtor criarPersonagem(PersonagemRequest personagemRequest) throws InvalidArgumentsExceptions {

        Ator ator = atorRepository.findByIdEquals(personagemRequest.getIdAtor());
        if (ator == null) {
            throw new InvalidArgumentsExceptions("Nenhum ator encontrado com o parâmetro id={" + personagemRequest.getIdAtor() +"}, favor verifique os parâmetros informados.");
        }

        PersonagemAtor personagem = new PersonagemAtor(ator, personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());

        List<PersonagemAtor> personagensCadastrados = personagemAtorRepository.findAll();
        boolean personagemJaCadastrado = false;
        Integer id = 0;
        for (PersonagemAtor personagemCadastrado : personagensCadastrados) {
            if (personagemCadastrado.getNomePersonagem().equals(personagem.getNomePersonagem()) && personagemCadastrado.getAtor().equals(personagem.getAtor())) {
                personagemJaCadastrado = true;
                id = personagemCadastrado.getId();
            }
        }
        if (!personagemJaCadastrado) {
            return personagemAtorRepository.save(personagem);
        } else {
            return personagemAtorRepository.findByIdEquals(id);
        }
    }
}
