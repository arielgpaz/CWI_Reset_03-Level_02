package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {dataNascimento}.")
    @Past
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {statusCarreira}.")
    private StatusCarreira statusCarreira;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {anoInicioAtividade}.")
    private Integer anoInicioAtividade;

    public Ator(Integer id, String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }
    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
