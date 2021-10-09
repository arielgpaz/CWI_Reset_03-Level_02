package exercicio;

public class Ator extends Pessoa {

    private Integer numeroOscarsVencidos;

    public Ator(String nome, Integer idade, Integer numeroOscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }
}
