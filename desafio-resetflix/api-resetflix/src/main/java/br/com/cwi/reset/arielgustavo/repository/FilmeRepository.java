package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.Filme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Integer> {

}
