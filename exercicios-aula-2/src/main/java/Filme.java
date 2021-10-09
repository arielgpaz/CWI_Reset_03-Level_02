public class Filme {

    private String nome;
    private String descricao;
    private int duracao;
    private int anoLancamento;
    private double avaliacao;


    public Filme(String nome, String descricao, int duracao, int anoLancamento, double avaliacao) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void reproduzir () {
        System.out.println("Nome do filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
    }

}
