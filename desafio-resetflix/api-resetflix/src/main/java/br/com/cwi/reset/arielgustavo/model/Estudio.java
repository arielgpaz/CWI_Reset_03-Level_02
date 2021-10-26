package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {descricao}.")
    private String descricao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {dataCriacao}.")
    @Past
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {statusAtividade}.")
    private StatusAtividade statusAtividade;

    public Estudio(Integer id, String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public StatusAtividade getStatusAtividade() {
        return statusAtividade;
    }
}
