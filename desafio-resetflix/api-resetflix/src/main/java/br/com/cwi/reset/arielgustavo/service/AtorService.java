package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.StatusCarreira;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) throws InvalidArgumentsExceptions {

        if (atorRequest.getNome().split(" ").length < 2) {
            throw new InvalidArgumentsExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (atorRequest.getAnoInicioAtividade() < atorRequest.getDataNascimento().getYear()) {
            throw new InvalidArgumentsExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }

        List<Ator> atores = fakeDatabase.recuperaAtores();
        for (Ator atorCadastrado : atores) {
            if (atorRequest.getNome().equalsIgnoreCase(atorCadastrado.getNome())) {
                throw new InvalidArgumentsExceptions("Já existe um ator cadastrado para o nome {nome}.");
            }
        }

        Ator ator = new Ator((fakeDatabase.recuperaAtores().size() + 1), atorRequest.getNome(),atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws InvalidArgumentsExceptions {
        List<Ator> atores = new ArrayList<>(fakeDatabase.recuperaAtores());
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        if (filtroNome != null) {
            atores = atores.stream()
                    .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()) && ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                    .collect(Collectors.toList());
            if (atores.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Ator não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        } else {
            atores = atores.stream()
                    .filter(ator -> ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                    .collect(Collectors.toList());
            if (atores.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Ator não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        }
        return atores;
    }

    public Ator consultarAtor(Integer id) throws InvalidArgumentsExceptions {
        if (id != null) {
            List<Ator> atores = new ArrayList<>(fakeDatabase.recuperaAtores());
            for (Ator ator : atores) {
                if(id.equals(ator.getId())){
                    return ator;
                }
            }
            throw new InvalidArgumentsExceptions(String.format("Nenhum ator encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
    }

    public List<Ator> consultarAtores() throws InvalidArgumentsExceptions {
        List<Ator> atores = new ArrayList<>(fakeDatabase.recuperaAtores());
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        return atores;
    }
}
