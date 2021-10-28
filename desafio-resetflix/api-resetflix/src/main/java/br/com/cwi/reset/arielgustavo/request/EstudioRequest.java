package br.com.cwi.reset.arielgustavo.request;

import br.com.cwi.reset.arielgustavo.model.StatusAtividade;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class EstudioRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {descricao}.")
    private String descricao;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {dataCriacao}.")
    @Past(message = "Não é possível cadastrar estúdios do futuro.")
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {statusAtividade}.")
    private StatusAtividade statusAtividade;

    public EstudioRequest(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
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
