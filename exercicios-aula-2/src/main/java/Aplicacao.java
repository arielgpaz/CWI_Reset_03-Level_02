public class Aplicacao {

    public static void main(String[] args) {
        Filme filme1 = new Filme("Aprendendo Java", "Aqui você vê os primeiros passos de Orientação à Objetos", 20, 2021, 4);
        Filme filme2 = new Filme("Aprendendo Java 2", "Evoluindo até resetar a carreira", 90, 2021, 4.5);

        filme1.reproduzir();
        System.out.println("----------------------------------------");
        filme2.reproduzir();
    }
}
