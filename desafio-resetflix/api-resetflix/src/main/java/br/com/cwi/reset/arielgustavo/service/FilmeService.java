package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.*;
import br.com.cwi.reset.arielgustavo.request.FilmeRequest;
import br.com.cwi.reset.arielgustavo.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private AtorService atorService;
    private DiretorService diretorService;
    private EstudioService estudioService;
    private PersonagemAtorService personagemAtorService;

    public FilmeService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
        this.atorService = new AtorService(FakeDatabase.getInstance());
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
        this.personagemAtorService = new PersonagemAtorService(FakeDatabase.getInstance());
    }

    public void criarFilme(FilmeRequest filmeRequest) throws InvalidArgumentsExceptions {

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();
        boolean idEstudioExiste = false;
        for (Estudio estudio : estudios) {
            if (estudio.getId().equals(filmeRequest.getIdEstudio())) {
                idEstudioExiste = true;
                break;
            }
        }
        if (!idEstudioExiste) {
            throw new InvalidArgumentsExceptions(String.format("Nenhum estúdio encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", filmeRequest.getIdEstudio()));
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();
        boolean idDiretorExiste = false;
        for (Diretor diretor : diretores) {
            if (diretor.getId().equals(filmeRequest.getIdDiretor())) {
                idDiretorExiste = true;
                break;
            }
        }
        if (!idDiretorExiste) {
            throw new InvalidArgumentsExceptions(String.format("Nenhum diretor encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", filmeRequest.getIdDiretor()));
        }

        List<PersonagemAtor> personagens = new ArrayList<>();

        for (int i = 0; i < filmeRequest.getPersonagens().size(); i++) {
            PersonagemRequest personagemRequestFilme = new PersonagemRequest(filmeRequest.getPersonagens().get(i).getIdAtor(), filmeRequest.getPersonagens().get(i).getNomePersonagem(), filmeRequest.getPersonagens().get(i).getDescricaoPersonagem(), filmeRequest.getPersonagens().get(i).getTipoAtuacao());
            personagens.add(new PersonagemAtor(fakeDatabase.recuperaPersonagens().size() +1, filmeRequest.getPersonagens().get(i).getIdAtor(), filmeRequest.getPersonagens().get(i).getNomePersonagem(), filmeRequest.getPersonagens().get(i).getDescricaoPersonagem(), filmeRequest.getPersonagens().get(i).getTipoAtuacao()));
            personagemAtorService.criarPersonagem(personagemRequestFilme);
        }

        Filme filme = new Filme((fakeDatabase.recuperaFilmes().size() + 1), filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(),
                diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                estudioService.consultarEstudio(filmeRequest.getIdEstudio()), personagens,
                filmeRequest.getResumo());

        fakeDatabase.persisteFilme(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws InvalidArgumentsExceptions {

        List<Filme> filmes = new ArrayList<>(fakeDatabase.recuperaFilmes());
        List<Filme> filmeEncontrado = new ArrayList<>();

        if (filmes == null) {
            throw new InvalidArgumentsExceptions("Nenhum filme cadastrado, favor cadastar filmes.");
        }

        if (nomeFilme != null) {
            filmeEncontrado = filmes.stream()
                    .filter(filme -> filme.getNome().toUpperCase().contains(nomeFilme.toUpperCase()))
                    .collect(Collectors.toList());
            return filmeEncontrado;

        } else if (nomeDiretor != null) {
            filmeEncontrado = filmes.stream()
                    .filter(filme -> filme.getDiretor().getNome().toUpperCase().contains(nomeDiretor.toUpperCase()))
                    .collect(Collectors.toList());
            return filmeEncontrado;

        } else if (nomePersonagem != null) {

            List<PersonagemAtor> personagens = new ArrayList<>(fakeDatabase.recuperaPersonagens());
            for (int i = 0; i < personagens.size(); i++) {
                if (personagens.get(i).getNomePersonagem().equals(nomePersonagem)) {
                    int finalI = i;
                    filmeEncontrado = filmes.stream()
                            .filter(filme -> filme.getPersonagens().get(finalI).getNomePersonagem().toUpperCase().contains(nomeDiretor.toUpperCase()))
                            .collect(Collectors.toList());
                    break;
                }
            }
            return filmeEncontrado;

        } else {
            List<Ator> atores = new ArrayList<>(fakeDatabase.recuperaAtores());
            for (int i = 0; i < atores.size(); i++) {
                if (atores.get(i).getNome().equals(nomeAtor)) {
                    int finalI = i;
                    filmeEncontrado = filmes.stream()
                            .filter(filme -> filme.getPersonagens().get(finalI).getIdAtor().equals(atores.get(finalI).getId()))
                            .collect(Collectors.toList());
                    break;
                }
            }
            if (filmeEncontrado.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Filme não encontrato com os filtros nomeFilme={%s}, nomeDiretor={%s}, nomePersonagem={%s}, nomeAtor={%s}, favor informar outros filtros.", nomeFilme, nomeDiretor, nomePersonagem, nomeAtor));
            }
        }
        return filmeEncontrado;
    }

}
