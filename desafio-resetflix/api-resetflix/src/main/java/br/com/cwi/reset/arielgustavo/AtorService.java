package br.com.cwi.reset.arielgustavo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // Demais métodos da classe
    public void criarAtor(AtorRequest atorRequest) {
        Ator ator = new Ator((fakeDatabase.recuperaAtores().size() + 1), atorRequest.getNome(),atorRequest.getDataNascimento(), atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade());
        fakeDatabase.persisteAtor(ator);
    }

    public List<Ator> listarAtoresEmAtividade(String filtroNome) throws InvalidArgumentsExceptions {
        List<Ator> atores = new ArrayList<>(fakeDatabase.recuperaAtores());
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum ator cadastrado, favor cadastar atores.");
        }
        atores = atores.stream()
                .filter(ator -> ator.getNome().toUpperCase().contains(filtroNome.toUpperCase()) && ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE))
                .collect(Collectors.toList());
        if (atores.isEmpty()) {
            throw new InvalidArgumentsExceptions(String.format("Ator não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
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
