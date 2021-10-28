package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Genero> generos;
    @ManyToOne
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;
    @ManyToOne
    @JoinColumn(name = "id_estudio")
    private Estudio estudio;
    @OneToMany
    @JoinColumn(name = "id_personagem_ator")
    private List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, Estudio estudio, List<PersonagemAtor> personagens, String resumo) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.estudio = estudio;
        this.personagens = personagens;
        this.resumo = resumo;
    }

    public Filme() {
    }

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public String getCapaFilme() {
        return capaFilme;
    }
    public List<Genero> getGeneros() {
        return generos;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public Estudio getEstudio() {
        return estudio;
    }
    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }
    public String getResumo() {
        return resumo;
    }
}
