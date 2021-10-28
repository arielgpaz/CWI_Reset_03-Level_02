package br.com.cwi.reset.arielgustavo.service;

import br.com.cwi.reset.arielgustavo.exception.InvalidArgumentsExceptions;
import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.model.StatusAtividade;
import br.com.cwi.reset.arielgustavo.repository.EstudioRepository;
import br.com.cwi.reset.arielgustavo.request.EstudioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public void criarEstudio(EstudioRequest estudioRequest) throws InvalidArgumentsExceptions {

        Estudio estudioCadastrado = estudioRepository.findByNomeIgnoringCase(estudioRequest.getNome());
        if (estudioCadastrado != null) {
            throw new InvalidArgumentsExceptions(String.format("Já existe um estúdio cadastrado para o nome %s", estudioRequest.getNome()));
        }

        Estudio estudio = new Estudio(estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade());
        estudioRepository.save(estudio);
    }

    public List<Estudio> listarEstudio(String filtroNome) throws InvalidArgumentsExceptions {
        Iterable<Estudio> estudios = estudioRepository.findAll();
        if (estudios == null) {
            throw new InvalidArgumentsExceptions("Nenhum estúdio cadastrado, favor cadastar estúdios.");
        }
        if (filtroNome != null) {
            List<Estudio> estudio = estudioRepository.findByNomeContainsIgnoringCase(filtroNome);
            if (estudio.isEmpty()) {
                throw new InvalidArgumentsExceptions(String.format("Estúdio não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
            return estudio;
        }
        else {
            List<Estudio> estudiosEmAtividade = estudioRepository.findByStatusAtividade(StatusAtividade.EM_ATIVIDADE);
            if (estudios == null) {
                throw new InvalidArgumentsExceptions(String.format("Estúdio não encontrato com o filtro {%s}, favor informar outro filtro.", filtroNome));
            }
            return estudiosEmAtividade;
        }
    }

    public Estudio consultarEstudio(Integer id) throws InvalidArgumentsExceptions {
        if (id != null) {
            Estudio estudio = estudioRepository.findByIdEquals(id);
            if (estudio == null) {
                throw new InvalidArgumentsExceptions(String.format("Nenhum estúdio encontrado com o parâmetro id={%d}, favor verifique os parâmetros informados.", id));
            }
            return estudio;
        } else {
            throw new InvalidArgumentsExceptions("Campo obrigatório não informado. Favor informar o campo {id}.");
        }
    }
}
