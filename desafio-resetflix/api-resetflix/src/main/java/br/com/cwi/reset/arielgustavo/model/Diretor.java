package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {nome}.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {dataNascimento}.")
    @Past
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo {anoInicioAtividade}.")
    private Integer anoInicioAtividade;

    public Diretor(Integer id, String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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
    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
