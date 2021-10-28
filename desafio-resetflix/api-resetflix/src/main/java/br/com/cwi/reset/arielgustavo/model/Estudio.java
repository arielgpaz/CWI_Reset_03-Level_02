package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    @Enumerated(EnumType.STRING)
    private StatusAtividade statusAtividade;

    public Estudio(String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }

    public Estudio() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudio estudio = (Estudio) o;
        return Objects.equals(id, estudio.id) && Objects.equals(nome, estudio.nome) && Objects.equals(descricao, estudio.descricao) && Objects.equals(dataCriacao, estudio.dataCriacao) && statusAtividade == estudio.statusAtividade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, dataCriacao, statusAtividade);
    }
}
