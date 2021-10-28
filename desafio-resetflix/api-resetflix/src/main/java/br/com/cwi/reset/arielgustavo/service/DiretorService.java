package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.model.Filme;
import br.com.cwi.reset.arielgustavo.repository.DiretorRepository;
import br.com.cwi.reset.arielgustavo.repository.FilmeRepository;
import br.com.cwi.reset.arielgustavo.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {

        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new InvalidArgumentsExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            throw new InvalidArgumentsExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }

        Diretor diretorJaExistente = diretorRepository.findByNomeIgnoringCase(diretorRequest.getNome());
        if (diretorJaExistente != null) {
            throw new InvalidArgumentsExceptions("Já existe um ator cadastrado para o nome {nome}.");
        }

        Diretor diretor = new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        diretorRepository.save(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws InvalidArgumentsExceptions {

        if(filtroNome != null) {
            List<Diretor> diretores = diretorRepository.findByNomeContainsIgnoringCase(filtroNome);
            if (diretores == null) {
                throw new InvalidArgumentsExceptions(String.format("Diretor não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
            return diretores;
        } else {
            List<Diretor> diretores = diretorRepository.findAll();
            if (diretores == null) {
                throw new InvalidArgumentsExceptions("Nenhum diretor cadastrado, favor cadastar diretores.");
            }
            return diretores;
        }
    }

    public Diretor consultarDiretor(Integer id) throws InvalidArgumentsExceptions {
        if (id != null) {
            Diretor diretor = diretorRepository.findByIdEquals(id);
            if (diretor == null) {
                throw new InvalidArgumentsExceptions(String.format("Nenhum diretor encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
            }
            return diretor;
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
    }

    public void atualizarDiretor(Integer id, DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {
        if (id == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }

        Diretor diretorJaExistente = diretorRepository.findByIdEquals(id);
        if (diretorJaExistente == null) {
            throw new InvalidArgumentsExceptions(String.format("Nenhum diretor encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
        }
        diretorRepository.save(diretorJaExistente);
    }

    public void removerDiretor(Integer id) throws InvalidArgumentsExceptions {
        if (id == null ) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
        Diretor diretorJaExistente = diretorRepository.findByIdEquals(id);
        if(diretorJaExistente == null) {
            throw new InvalidArgumentsExceptions("Nenhum diretor encontrado com o parâmetro id={" + id + "}, favor verifique os parâmetros informados.");
        }
        List<Filme> filmeDirigidoPeloDiretorProcurado = filmeRepository.findByDiretorNomeContainsIgnoringCase(diretorJaExistente.getNome());
        if (!filmeDirigidoPeloDiretorProcurado.isEmpty()) {
            throw new InvalidArgumentsExceptions( "Este diretor está vinculado a um ou mais filmes, para remover o diretor é necessário remover os seus filmes de participação.");
        }
        diretorRepository.delete(diretorJaExistente);
    }
}
