public class Diretor {

    public String nome;
    private int idade;
    private int quantidadeFilmesDigiridos;

    public Diretor(String nome, int idade, int quantidadeFilmesDigiridos) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
    }

    public String getNome() {
        return nome;
    }
}
