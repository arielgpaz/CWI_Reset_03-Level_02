package br.com.cwi.reset.primeiroprojetospring.domain;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;

//  Constructor
    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }
//  Getters
    public String getNome() {
        return nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public Genero getGenero() {
        return genero;
    }
//  Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
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
