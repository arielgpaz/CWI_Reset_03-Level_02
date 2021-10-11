package br.com.cwi.reset.arielgustavo;

public enum StatusAtividade {
    EM_ATIVIDADE("Em atividade"),
    ENCERRADO("Encerrado");

    private String descricao;

    StatusAtividade(String descrição) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
