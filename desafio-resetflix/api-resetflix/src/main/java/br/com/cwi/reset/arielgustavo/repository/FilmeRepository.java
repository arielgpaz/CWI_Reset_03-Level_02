package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    List<Filme> findByNomeContainsIgnoringCase(String nomeFilme);

    List<Filme> findByDiretorNomeContainsIgnoringCase(String nomeDiretor);

    List<Filme> findAll();

    List<Filme> findByPersonagensNomePersonagemContainsIgnoringCase(String nomePersonagem);

    List<Filme> findByPersonagensAtorNomeContainsIgnoringCase(String nomeAtor);

}
