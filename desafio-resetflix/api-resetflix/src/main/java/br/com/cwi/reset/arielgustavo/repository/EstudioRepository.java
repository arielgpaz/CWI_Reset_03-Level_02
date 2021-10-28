package br.com.cwi.reset.arielgustavo.repository;

import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.model.StatusAtividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio findByNomeIgnoringCase(String nome);

    List<Estudio> findByNomeContainsIgnoringCase(String nome);

    List<Estudio> findByStatusAtividade(StatusAtividade statusAtividade);

    Estudio findByIdEquals(Integer id);
}
