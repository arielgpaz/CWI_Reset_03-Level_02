package exercicio;

public class Aplicacao {

    public static void main(String[] args) {

        Diretor diretor = new Diretor("Ariel", 25, 2, Genero.MASCULINO);
        Filme minions = new Filme("Minions", "Pocurando chefe vilão", 120, 2019, 5.0, diretor);
        Filme meuMalvadoFavorito = new Filme("Meu Malvado Favorito", "Fazendo maldades", 90, 2017, 5.0, diretor);

        minions.reproduzir();
        System.out.println("----------------------------------------");
        meuMalvadoFavorito.reproduzir();
        System.out.println("----------------------------------------");
        diretor.imprimir();
    }
}
