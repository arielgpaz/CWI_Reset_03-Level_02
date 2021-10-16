package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer numeroOscarsVencidos;

//  Constructor
    public Ator(String nome, LocalDate dataNascimento, Integer numeroOscarsVencidos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }
//  Getters
    public Integer getNumeroOscarsVencidos() {
        return numeroOscarsVencidos;
    }
//  Setters
    public void setNumeroOscarsVencidos(Integer numeroOscarsVencidos) {
        this.numeroOscarsVencidos = numeroOscarsVencidos;
    }
}
