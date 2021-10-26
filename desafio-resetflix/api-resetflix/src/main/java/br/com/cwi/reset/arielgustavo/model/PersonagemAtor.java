package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class PersonagemAtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {idAtor}.")
    private Integer idAtor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nomePersonagem}.")
    private String nomePersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {descricaoPersonagem}.")
    private String descricaoPersonagem;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {tipoAtuacao}.")
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Integer id, Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.id = id;
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getId() {
        return id;
    }
    public Integer getIdAtor() {
        return idAtor;
    }
    public String getNomePersonagem() {
        return nomePersonagem;
    }
    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }
    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }
}
