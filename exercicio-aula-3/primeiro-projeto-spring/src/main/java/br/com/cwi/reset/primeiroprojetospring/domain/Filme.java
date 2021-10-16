package br.com.cwi.reset.primeiroprojetospring.domain;

public class Filme {

    private String nome;
    private String descricao;
    private Integer duracao;
    private Integer anoLancamento;
    private Double avaliacao;
    private Diretor diretor;

//  Constructor
    public Filme(String nome, String descricao, Integer duracao, Integer anoLancamento, Double avaliacao, Diretor diretor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }
//  Getters
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public Integer getDuracao() {
        return duracao;
    }
    public Integer getAnoLancamento() {
        return anoLancamento;
    }
    public Double getAvaliacao() {
        return avaliacao;
    }
    public Diretor getDiretor() {
        return diretor;
    }
//  Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public void reproduzir () {

        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Diretor: " + diretor.getNome());
    }

}