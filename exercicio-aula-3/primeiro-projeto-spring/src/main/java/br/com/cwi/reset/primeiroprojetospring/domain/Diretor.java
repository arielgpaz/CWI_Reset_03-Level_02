package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private Integer quantidadeFilmesDigiridos;

//  Constructor
    public Diretor(String nome, LocalDate dataNascimento, Integer quantidadeFilmesDigiridos, Genero genero) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
    }
//  Getters
    public Integer getQuantidadeFilmesDigiridos() {
        return quantidadeFilmesDigiridos;
    }
//  Setters
    public void setQuantidadeFilmesDigiridos(Integer quantidadeFilmesDigiridos) {
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
    }
}
