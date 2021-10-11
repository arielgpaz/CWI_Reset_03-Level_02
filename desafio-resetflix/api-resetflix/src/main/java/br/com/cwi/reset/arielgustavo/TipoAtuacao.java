package br.com.cwi.reset.arielgustavo;

public enum TipoAtuacao {
    PRINCIPAL("Principal"),
    COADJUVANTE("Coadjuvate");

    private String descricao;

    TipoAtuacao(String descrição) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
