package exercicio;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void imprimir(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + calcularIdade(dataNascimento));
        System.out.println("Gênero: " + genero.getDescricao());
    }

    public int calcularIdade( LocalDate dataNascimento) {
         LocalDate dataAtual = LocalDate.now();
         Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }
}
