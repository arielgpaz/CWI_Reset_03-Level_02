package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {anoLancamento}.")
    private Integer anoLancamento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {capaFilme}.")
    private String capaFilme;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {generos}.")
    private List<Genero> generos;
    @ManyToOne
    @JoinColumn(name = "id_diretor")
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {diretor}.")
    private Diretor diretor;
    @ManyToOne
    @JoinColumn(name = "id_estudio")
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {estudio}.")
    private Estudio estudio;
    @OneToMany
    @JoinColumn(name = "id_personagem_ator")
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {personagens}.")
    private List<PersonagemAtor> personagens;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {resumo}.")
    private String resumo;

    public Filme(Integer id, String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, Estudio estudio, List<PersonagemAtor> personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.estudio = estudio;
        this.personagens = personagens;
        this.resumo = resumo;
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
