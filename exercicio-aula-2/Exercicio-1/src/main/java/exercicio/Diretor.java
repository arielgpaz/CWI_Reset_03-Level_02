package exercicio;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmesDigiridos;

    public Diretor(String nome, LocalDate dataNascimento, Integer quantidadeFilmesDigiridos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
    }
}
