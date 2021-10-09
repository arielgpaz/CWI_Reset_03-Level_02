package exercicio;

public class Diretor {

    private String nome;
    private Integer idade;
    private Integer quantidadeFilmesDigiridos;
    private Genero genero;

    public Diretor(String nome, Integer idade, Integer quantidadeFilmesDigiridos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmesDigiridos = quantidadeFilmesDigiridos;
        this.genero = genero;

    }

    public String getNome() {
        return nome;
    }

    public void imprimir (){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero);
    }
}
