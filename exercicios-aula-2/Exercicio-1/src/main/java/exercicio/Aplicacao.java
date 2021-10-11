package exercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {

        Diretor diretor = new Diretor("Ariel", LocalDate.of(1996, 6, 7), 2, Genero.MASCULINO);

        List<Filme> filmes = new ArrayList<>();
        filmes.add(new Filme("Meu Malvado Favorito", "Fazendo maldades", 90, 2017, 5.0, diretor));
        filmes.add(new Filme("Meu Malvado Favorito 2", "O melhor malvado bonzinho", 105, 2019, 4.9, diretor));
        filmes.add(new Filme("Minions", "Pocurando chefe vilão", 120, 2019, 5.0, diretor));
        filmes.add(new Filme("Minions 2", "aguardando lançamento", 115, 2022, 0.0, diretor));

        for(Filme filme : filmes) {
            try {
                filme.reproduzir();
            } catch (AvaliacaoForaDoPadraoException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("----------------------------------------");
        }

        System.out.println("Impimindo atributos do diretor...");
        diretor.imprimir();
    }
}
