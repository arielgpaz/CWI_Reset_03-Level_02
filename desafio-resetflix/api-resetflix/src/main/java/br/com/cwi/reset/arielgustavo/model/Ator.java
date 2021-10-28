package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "atores")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDate dataNascimento;
    @Enumerated(EnumType.STRING)
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public Ator(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Ator() {
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

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setStatusCarreira(StatusCarreira statusCarreira) {
        this.statusCarreira = statusCarreira;
    }
    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
