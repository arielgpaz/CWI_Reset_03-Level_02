package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personagens")
public class PersonagemAtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_ator")
    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    @Enumerated(EnumType.STRING)
    private TipoAtuacao tipoAtuacao;

    public PersonagemAtor(Ator ator, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public PersonagemAtor() {
    }

    public Integer getId() {
        return id;
    }
    public Ator getAtor() {
        return ator;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonagemAtor that = (PersonagemAtor) o;
        return Objects.equals(id, that.id) && Objects.equals(ator, that.ator) && Objects.equals(nomePersonagem, that.nomePersonagem) && Objects.equals(descricaoPersonagem, that.descricaoPersonagem) && tipoAtuacao == that.tipoAtuacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ator, nomePersonagem, descricaoPersonagem, tipoAtuacao);
    }
}
