package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    Diretor findByNomeIgnoringCase(String nome);

    List<Diretor> findByNomeContainsIgnoringCase(String filtroNome);

    List<Diretor> findAll();

    Diretor findByIdEquals(Integer id);

}
