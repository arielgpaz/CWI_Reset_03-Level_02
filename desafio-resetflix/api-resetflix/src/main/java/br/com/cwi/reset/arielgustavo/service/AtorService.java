package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.StatusCarreira;
import br.com.cwi.reset.arielgustavo.repository.AtorRepository;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws InvalidArgumentsExceptions {

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new InvalidArgumentsExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new InvalidArgumentsExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }

        Ator atorJaExistente = atorRepository.findByNomeIgnoringCase(atorRequest.getNome());
        if (atorJaExistente != null) {
            throw new InvalidArgumentsExceptions("Já existe um ator cadastrado para o nome {nome}.");
        }

        Ator ator = new Ator(atorRequest.getNome(),atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        atorRepository.save(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws InvalidArgumentsExceptions {

        List<Ator> atores = atorRepository.findAll();
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }

        if (filtroNome != null) {
            atores = atorRepository.findByNomeContainingAndStatusCarreira(filtroNome, StatusCarreira.EM_ATIVIDADE);
            if (atores.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Ator não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        } else {
            atores = atorRepository.findByStatusCarreira(StatusCarreira.EM_ATIVIDADE);
            if (atores.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Ator não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        }
        return atores;
    }

    public Ator consultarAtor(Integer id) throws InvalidArgumentsExceptions {

        if (id != null) {
            Ator ator = atorRepository.findByIdEquals(id);
            if (ator == null) {
                throw new InvalidArgumentsExceptions(String.format("Nenhum ator encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
            } else {
                return ator;
            }
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
    }

    public List<Ator> consultarAtores() throws InvalidArgumentsExceptions {
        List<Ator> atores = atorRepository.findAll();
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return atores;
    }
}
