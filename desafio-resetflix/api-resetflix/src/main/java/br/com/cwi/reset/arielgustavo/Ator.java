package br.com.cwi.reset.arielgustavo;

import java.time.LocalDate;

public class Ator {

    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private LocalDate anoInicioAtividade;

    public String getNome() {
        return nome;
    }

}
