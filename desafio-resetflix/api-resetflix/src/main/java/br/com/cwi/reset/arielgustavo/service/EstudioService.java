package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.FakeDatabase;
import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.model.StatusAtividade;
import br.com.cwi.reset.arielgustavo.model.StatusCarreira;
import br.com.cwi.reset.arielgustavo.request.AtorRequest;
import br.com.cwi.reset.arielgustavo.request.EstudioRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    public void criarEstudio(EstudioRequest estudioRequest) throws InvalidArgumentsExceptions {

        if (estudioRequest.getNome() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {nome}.");
        }

        if (estudioRequest.getDataCriacao() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {dataCriacao}.");
        }

        if (estudioRequest.getDescricao() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {descricao}.");
        }

        if (estudioRequest.getStatusAtividade() == null) {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {statusAtividade}.");
        }


        if (estudioRequest.getDataCriacao().isAfter(LocalDate.now())) {
            throw new InvalidArgumentsExceptions("Não é possível cadastrar estúdios do futuro.");
        }

        List<Estudio> estudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudioCadastrado : estudios) {
            if (estudioRequest.getNome().equalsIgnoreCase(estudioCadastrado.getNome())) {
                throw new InvalidArgumentsExceptions(String.format("Já existe um estúdio cadastrado para o nome %s", estudioRequest.getNome()));
            }
        }

        Estudio estudio = new Estudio((fakeDatabase.recuperaEstudios().size() + 1), estudioRequest.getNome(),estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        fakeDatabase.persisteEstudio(estudio);
    }

    public List<Estudio> listarEstudio(String filtroNome) throws InvalidArgumentsExceptions {
        List<Estudio> estudios = new ArrayList<>(fakeDatabase.recuperaEstudios());
        if (estudios.isEmpty()) {
            throw new InvalidArgumentsExceptions("Nenhum estúdio cadastrado, favor cadastar estúdios.");
        }
        if (filtroNome != null) {
            estudios = estudios.stream()
                    .filter(estudio -> estudio.getNome().toUpperCase().contains(filtroNome.toUpperCase()))
                    .collect(Collectors.toList());
            if (estudios.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Estúdio não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        }
        else {
            estudios = estudios.stream()
                    .filter(estudio -> estudio.getStatusAtividade().equals(StatusAtividade.EM_ATIVIDADE))
                    .collect(Collectors.toList());
            if (estudios.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Estúdio não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
        }
        return estudios;
    }

    public Estudio consultarEstudio(Integer id) throws InvalidArgumentsExceptions {
        if (id != null) {
            List<Estudio> estudios = new ArrayList<>(fakeDatabase.recuperaEstudios());
            for (Estudio estudio : estudios) {
                if(id.equals(estudio.getId())){
                    return estudio;
                }
            }
            throw new InvalidArgumentsExceptions(String.format("Nenhum estúdio encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
    }
}
