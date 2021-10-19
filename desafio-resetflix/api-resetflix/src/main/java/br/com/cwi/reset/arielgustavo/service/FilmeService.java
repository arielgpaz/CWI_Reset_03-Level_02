package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.Filme;
import br.com.cwi.reset.arielgustavo.model.StatusCarreira;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import br.com.cwi.reset.arielgustavo.request.FilmeRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemService personagemService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
    }

    public void criarFilme(FilmeRequest filmeRequest) throws InvalidArgumentsExceptions {

        if (filmeRequest.getNome() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {nome}.");
        }

        if (filmeRequest.getAnoLancamento() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {anoLancamento}.");
        }

        if (filmeRequest.getCapaFilme() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {capaFilme}.");
        }

        if (filmeRequest.getGeneros() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {genero}.");
        }

        if (filmeRequest.getDiretor().getId() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {diretor}.");
        }

        if (filmeRequest.getEstudio().getId() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {estudio}.");
        }

        if (filmeRequest.getResumo() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {resumo}.");
        }

//        Revisar aqui!!!

        List<Filme> filmes = fakeDatabase.recuperaFilmes();

        Filme filme = new Filme((fakeDatabase.recuperaFilmes().size() + 1), filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(),
                filmeRequest.getDiretor(), filmeRequest.getEstudio(), filmeRequest.getPersonagens(),
                filmeRequest.getResumo());

        fakeDatabase.persisteFilme(filme);
    }

}
