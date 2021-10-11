package br.com.cwi.reset.arielgustavo;

public enum StatusCarreira {
    EM_ATIVIDADE("Em atividade"),
    APOSENTADO("Aposentado");

    private String descricao;

    StatusCarreira(String descrição) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}