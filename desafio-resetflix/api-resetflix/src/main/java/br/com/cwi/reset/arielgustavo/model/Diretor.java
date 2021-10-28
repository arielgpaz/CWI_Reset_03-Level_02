package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "diretores")
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDate dataNascimento;
    private Integer anoInicioAtividade;

    public Diretor(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public Diretor() {
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
