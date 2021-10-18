package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")

public class FilmeController {

    private static List<Filme> filmes = new ArrayList<>();

//    @GetMapping
//    public Filme getFilme() {
//        Diretor diretor = new Diretor("Ariel", LocalDate.of(1996, 6, 7), 2, Genero.MASCULINO);
//        return new Filme("Minions", "Gostam de fazer maldades", 120, 2019, 5.0, diretor);
//    }

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        Filme filmeExistente = buscarFilmePeloNome(filme.getNome());

        if (filmeExistente != null) {
            return ResponseEntity.badRequest().build();
        }

        filmes.add(filme);
        return ResponseEntity.ok(filme);
    }

    @GetMapping
    public List<Filme> listaFilmesCadastrados() {
        return filmes;
    }

    @GetMapping("/{nome}")
    public Filme consultarFilmePeloNome(@PathVariable String nome) {
        return buscarFilmePeloNome(nome);
    }

    @DeleteMapping("/{nome}")
    public void deletarFilme(@PathVariable String nome) {
        Filme filme = buscarFilmePeloNome(nome);
        if(filme != null) {
            filmes.remove(filme);
        }
    }

    @PutMapping
    public Filme atualizarFilme(@RequestBody Filme filme) {
        Filme filmeCadastrado = buscarFilmePeloNome(filme.getNome());

        if(filmeCadastrado != null) {
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
            return filme;
        }
        return null;
    }

    private Filme buscarFilmePeloNome(String nome) {
        for (Filme filme : filmes) {
            if(nome.equals(filme.getNome())){
                return filme;
            }
        }
        return null;
    }
}
