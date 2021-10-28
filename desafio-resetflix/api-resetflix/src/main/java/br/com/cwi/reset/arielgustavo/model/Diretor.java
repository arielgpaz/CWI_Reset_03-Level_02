package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diretor diretor = (Diretor) o;
        return Objects.equals(id, diretor.id) && Objects.equals(nome, diretor.nome) && Objects.equals(dataNascimento, diretor.dataNascimento) && Objects.equals(anoInicioAtividade, diretor.anoInicioAtividade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, anoInicioAtividade);
    }
}
