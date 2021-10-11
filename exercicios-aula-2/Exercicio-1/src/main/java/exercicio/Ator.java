package exercicio;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer numeroOscarsVencidos;

    public Ator(String nome, LocalDate dataNascimento, Integer numeroOscarsVencidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }
}
