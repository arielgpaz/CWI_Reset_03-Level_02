package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Ator cadastrarAtor(Ator ator) throws AtorJaExistenteException {
        Ator atorJaExistente = atorRepository.findByNomeIgnoringCase(ator.getNome());

        if(atorJaExistente != null) {
            throw new AtorJaExistenteException("Já existe um ator cadastrado com o nome " + ator.getNome());
        }

        return atorRepository.save(ator);
    }

    public Ator consultarAtorPorNome (String nome) {
        return atorRepository.findByNomeIgnoringCase(nome);
    }

    public List<Ator> consultarPeloNumeroOscars (Integer numeroOscars) {
        return atorRepository.findByNumeroOscars(numeroOscars);
    }

    public void excluirAtor (Integer id) throws AtorNaoExistenteException {
//        Ator atorJaExistente = atorRepository.findById(id);
//        if (atorJaExistente == null) {
//            throw new AtorNaoExistenteException("O ator com id " + id + "não existe.");
//        }
        atorRepository.deleteById(id);
    }
}
