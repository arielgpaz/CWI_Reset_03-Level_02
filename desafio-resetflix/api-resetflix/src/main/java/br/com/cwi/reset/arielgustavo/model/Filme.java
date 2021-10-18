package br.com.cwi.reset.arielgustavo.model;

import java.time.LocalDate;
import java.util.List;

public class Filme {
    private Integer id;
    private String nome;
    private LocalDate anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Diretor diretor;
    private Estudio estudio;
    private List<PersonagemAtor> personagens;
    private String resumo;
}
