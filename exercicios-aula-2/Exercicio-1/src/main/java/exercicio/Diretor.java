package exercicio;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmesDigiridos;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmesDigiridos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
    }

}
