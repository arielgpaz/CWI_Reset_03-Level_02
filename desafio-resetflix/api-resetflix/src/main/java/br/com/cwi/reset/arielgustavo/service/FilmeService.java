package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.*;
import br.com.cwi.reset.arielgustavo.repository.*;
import br.com.cwi.reset.arielgustavo.request.FilmeRequest;
import br.com.cwi.reset.arielgustavo.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private EstudioRepository estudioRepository;
    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private PersonagemAtorRepository personagemAtorRepository;
    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private PersonagemAtorService personagemAtorService;

    public void criarFilme(FilmeRequest filmeRequest) throws InvalidArgumentsExceptions {

        Estudio estudio = estudioRepository.findByIdEquals(filmeRequest.getIdEstudio());
        if (estudio == null) {
            throw new InvalidArgumentsExceptions(String.format("Nenhum estúdio encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", filmeRequest.getIdEstudio()));
        }

        Diretor diretor = diretorRepository.findByIdEquals(filmeRequest.getIdDiretor());
        if (diretor == null) {
            throw new InvalidArgumentsExceptions(String.format("Nenhum diretor encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", filmeRequest.getIdDiretor()));
        }



        List<PersonagemAtor> personagens = new ArrayList<>();
        for (int i = 0; i < filmeRequest.getPersonagens().size(); i++) {
            PersonagemRequest personagemRequestFilme = new PersonagemRequest(filmeRequest.getPersonagens().get(i).getIdAtor(), filmeRequest.getPersonagens().get(i).getNomePersonagem(), filmeRequest.getPersonagens().get(i).getDescricaoPersonagem(), filmeRequest.getPersonagens().get(i).getTipoAtuacao());
            PersonagemAtor personagem = personagemAtorService.criarPersonagem(personagemRequestFilme);
            for (PersonagemAtor personagemCadastrado : personagens) {
                if (personagem.getNomePersonagem().equalsIgnoreCase(personagemCadastrado.getNomePersonagem()) && personagem.getAtor().getId().equals(personagemCadastrado.getAtor().getId())) {
                    throw new InvalidArgumentsExceptions("Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme.");
                }
            }
            personagens.add(personagem);
        }

        Filme filme = new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(), filmeRequest.getGeneros(), diretor, estudio, personagens, filmeRequest.getResumo());

        filmeRepository.save(filme);
    }

    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws InvalidArgumentsExceptions {

        List<Filme> filmes = filmeRepository.findAll();
        if (filmes == null) {
            throw new InvalidArgumentsExceptions("Nenhum filme cadastrado, favor cadastar filmes.");
        }

        List<Filme> filmeEncontrado;
        if (!nomeFilme.isEmpty()) {
            filmeEncontrado = filmeRepository.findByNomeContainsIgnoringCase(nomeFilme);
        } else if (!nomeDiretor.isEmpty()) {
            filmeEncontrado = filmeRepository.findByDiretorNomeContainsIgnoringCase(nomeDiretor);
        } else if (!nomePersonagem.isEmpty()) {
            filmeEncontrado = filmeRepository.findByPersonagensNomePersonagemContainsIgnoringCase(nomePersonagem);
        } else if (!nomeAtor.isEmpty()){
            filmeEncontrado = filmeRepository.findByPersonagensAtorNomeContainsIgnoringCase(nomeAtor);
        } else {
            filmeEncontrado = filmeRepository.findAll();
        }
        if (filmeEncontrado.isEmpty()) {
            throw new InvalidArgumentsExceptions(String.format("Filme não encontrato com os filtros nomeFilme={%s}, nomeDiretor={%s}, nomePersonagem={%s}, nomeAtor={%s}, favor informar outros filtros.", nomeFilme, nomeDiretor, nomePersonagem, nomeAtor));
        }
        return filmeEncontrado;
    }

    public void removerFilme(Integer id) {
        filmeRepository.deleteById(id);
    }
}
