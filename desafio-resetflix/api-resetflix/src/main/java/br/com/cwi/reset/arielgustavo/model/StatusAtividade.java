package br.com.cwi.reset.arielgustavo.model;

public enum StatusAtividade {
    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    private String descricao;

    StatusAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
