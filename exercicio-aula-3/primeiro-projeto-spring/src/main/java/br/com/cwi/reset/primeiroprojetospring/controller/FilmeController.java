package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/filme")

public class FilmeController {

    @GetMapping
    public Filme getFilme() {
        Diretor diretor = new Diretor("Ariel", LocalDate.of(1996, 6, 7), 2, Genero.MASCULINO);
        return new Filme("Minions", "Gostam de fazer maldades", 120, 2019, 5.0, diretor);
    }


}
