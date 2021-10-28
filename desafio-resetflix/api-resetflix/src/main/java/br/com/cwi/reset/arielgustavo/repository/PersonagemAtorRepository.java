package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemAtorRepository extends CrudRepository<PersonagemAtor, Integer> {

    List<PersonagemAtor> findAll();

    PersonagemAtor findByIdEquals(Integer id);

}
