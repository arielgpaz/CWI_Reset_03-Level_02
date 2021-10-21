package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.model.PersonagemAtor;
import br.com.cwi.reset.arielgustavo.request.PersonagemRequest;

import java.util.List;

public class PersonagemService {

    private FakeDatabase fakeDatabase;

    public PersonagemService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarPersonagem(PersonagemRequest personagemRequest) throws InvalidArgumentsExceptions {

        if (personagemRequest.getIdAtor() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {idAtor}.");
        }

        if (personagemRequest.getNomePersonagem() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {nomePersonagem}.");
        }

        if (personagemRequest.getDescricaoPersonagem() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {descricaoPersonagem}.");
        }

        if (personagemRequest.getTipoAtuacao() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {tipoAtuacao}.");
        }

        List<PersonagemAtor> personagens = fakeDatabase.recuperaPersonagens();

        for (PersonagemAtor personagemCadastrado : personagens) {
            if (personagemRequest.getNomePersonagem().equalsIgnoreCase(personagemCadastrado.getNomePersonagem()) && personagemRequest.getIdAtor().equals(personagemCadastrado.getIdAtor())) {
                throw new InvalidArgumentsExceptions("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
            }
        }

        PersonagemAtor personagem = new PersonagemAtor(fakeDatabase.recuperaPersonagens().size() +1, personagemRequest.getIdAtor(),personagemRequest.getNomePersonagem(), personagemRequest.getDescricaoPersonagem(), personagemRequest.getTipoAtuacao());
        fakeDatabase.persistePersonagem(personagem);
    }
}
