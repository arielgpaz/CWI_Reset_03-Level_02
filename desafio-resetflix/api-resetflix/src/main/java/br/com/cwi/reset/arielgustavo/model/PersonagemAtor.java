package br.com.cwi.reset.arielgustavo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
}
