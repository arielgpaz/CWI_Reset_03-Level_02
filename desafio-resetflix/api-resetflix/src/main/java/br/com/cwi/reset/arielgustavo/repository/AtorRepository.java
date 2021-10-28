package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.StatusCarreira;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByNomeIgnoringCase(String nome);

    List<Ator> findAll();

    List<Ator> findByNomeContainingAndStatusCarreira(String filtroNome, StatusCarreira statusCarreira);

    List<Ator> findByStatusCarreira(StatusCarreira statusCarreira);

    Ator findByIdEquals(Integer id);
}
