package br.com.cwi.reset.arielgustavo.request;

import br.com.cwi.reset.arielgustavo.model.Diretor;
import br.com.cwi.reset.arielgustavo.model.Estudio;
import br.com.cwi.reset.arielgustavo.model.Genero;
import br.com.cwi.reset.arielgustavo.model.PersonagemAtor;

import java.time.LocalDate;
import java.util.List;

public class FilmeRequest {

    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    private List<Genero> generos;
    private Integer idDiretor;
    private Integer idEstudio;
    private List<PersonagemAtor> personagens;
    private String resumo;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, List<PersonagemAtor> personagens, String resumo) {
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
    public List<PersonagemAtor> getPersonagens() {
        return personagens;
    }
    public String getResumo() {
        return resumo;
    }
}
