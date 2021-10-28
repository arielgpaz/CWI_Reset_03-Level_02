package br.com.cwi.reset.arielgustavo.request;

import br.com.cwi.reset.arielgustavo.model.Genero;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {anoLancamento}.")
    private Integer anoLancamento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {capaFilme}.")
    private String capaFilme;
    @ElementCollection
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {generos}.")
    private List<Genero> generos;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {diretor}.")
    private Integer idDiretor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {estudio}.")
    private Integer idEstudio;
    @OneToMany
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {personagens}.")
    private List<PersonagemRequest> personagens;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {resumo}.")
    private String resumo;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, List<PersonagemRequest> personagens, String resumo) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.personagens = personagens;
        this.resumo = resumo;
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
    public Integer getIdDiretor() {
        return idDiretor;
    }
    public Integer getIdEstudio() {
        return idEstudio;
    }
    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }
    public String getResumo() {
        return resumo;
    }
}
