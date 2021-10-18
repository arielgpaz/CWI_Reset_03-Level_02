package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.request.DiretorRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void cadastrarDiretor(DiretorRequest diretorRequest) throws InvalidArgumentsExceptions {

        if (diretorRequest.getNome() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {nome}.");
        }

        if (diretorRequest.getDataNascimento() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {dataNascimento}.");
        }

        if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {anoInicioAtividade}.");
        }

        if (diretorRequest.getNome().split(" ").length < 2) {
            throw new InvalidArgumentsExceptions("Deve ser informado no mínimo nome e sobrenome para o ator.");
        }

        if (diretorRequest.getDataNascimento().isAfter(LocalDate.now())) {
            throw new InvalidArgumentsExceptions("Não é possível cadastrar atores não nascidos.");
        }

        if (diretorRequest.getAnoInicioAtividade() < diretorRequest.getDataNascimento().getYear()) {
            throw new InvalidArgumentsExceptions("Ano de início de atividade inválido para o ator cadastrado.");
        }

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretorCadastrado : diretores) {
            if (diretorRequest.getNome().equalsIgnoreCase(diretorCadastrado.getNome())) {
                throw new InvalidArgumentsExceptions("Já existe um ator cadastrado para o nome {nome}.");
            }
        }

        Diretor diretor = new Diretor((fakeDatabase.recuperaDiretores().size() + 1), diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteDiretor(diretor);
    }

    public List<Diretor> listarDiretores(String filtroNome) throws InvalidArgumentsExceptions {
        List<Diretor> diretores = new ArrayList<>(fakeDatabase.recuperaDiretores());
        if (diretores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum diretor cadastrado, favor cadastar diretores.");
        }
        diretores = diretores.stream()
                .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
                .collect(Collectors.toList());
        if (diretores.isEmpty()) {
            throw new InvalidArgumentsExceptions(String.format("Diretor não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
        }
        return diretores;
    }

    public Diretor consultarDiretor(Integer id) throws InvalidArgumentsExceptions {
        if (id != null) {
            List<Diretor> diretores = new ArrayList<>(fakeDatabase.recuperaDiretores());
            for (Diretor diretor : diretores) {
                if (id.equals(diretor.getId())) {
                    return diretor;
                }
            }
            throw new InvalidArgumentsExceptions(String.format("Nenhum diretor encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }

    }
}
