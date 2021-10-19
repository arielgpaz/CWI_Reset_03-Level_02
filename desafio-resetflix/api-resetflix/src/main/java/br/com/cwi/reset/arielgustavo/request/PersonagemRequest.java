package br.com.cwi.reset.arielgustavo.request;

import br.com.cwi.reset.arielgustavo.model.Ator;
import br.com.cwi.reset.arielgustavo.model.TipoAtuacao;

public class PersonagemRequest {

    private Ator ator;
    private String nomePersonagem;
    private String descricaoPersonagem;
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Ator ator, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.ator = ator;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
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
