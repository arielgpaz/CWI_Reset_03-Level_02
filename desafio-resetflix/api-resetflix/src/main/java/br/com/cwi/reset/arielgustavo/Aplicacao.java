package br.com.cwi.reset.arielgustavo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {

    public static void main(String[] args) {
        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        System.out.println("------------------");

        // Teste para listar atores
//        System.out.println("------------------");
//        try {
//            String listaAtorEncontrado = atorService.listarAtoresEmAtividade("ill").get(0).getNome();
//            System.out.println(listaAtorEncontrado);
//        } catch (InvalidArgumentsExceptions e) {
//            System.out.println(e.getMessage());
//        }

        // Teste para consultar ator pela id
//        System.out.println("------------------");
//        try {
//            String atorEncontrado = atorService.consultarAtor(1).getNome();
//            System.out.println("O nome do ator encontrado pela id é " + atorEncontrado);
//        } catch (InvalidArgumentsExceptions e) {
//            System.out.println(e.getMessage());
//        }

        // Teste para consultar todos atores
//        System.out.println("------------------");
//        try {
//            List<Ator> atoresEncontrados = atorService.consultarAtores();
//            System.out.println("Atores foram encontrados");
//        } catch (InvalidArgumentsExceptions e) {
//            System.out.println(e.getMessage());
//        }


        DiretorService diretorService = new DiretorService(fakeDatabase);

        String nome1 = "Ariel Gustavo";
        LocalDate dataNascimento1 = LocalDate.of(1968, Month.SEPTEMBER, 25);
        Integer anoInicioAtividade1 = 1986;
        DiretorRequest diretorRequest = new DiretorRequest(nome1, dataNascimento1, anoInicioAtividade1);

        diretorService.cadastrarDiretor(diretorRequest);

        List<Diretor> diretores = fakeDatabase.recuperaDiretores();



        // Teste para listar diretores
//        System.out.println("------------------");
//        try {
//            String listaDiretorEncontrado = diretorService.listarDiretores("iek").get(0).getNome();
//            System.out.println(listaDiretorEncontrado);
//        } catch (InvalidArgumentsExceptions e) {
//            System.out.println(e.getMessage());
//        }


        // Teste para consultar diretor pela id
//        System.out.println("------------------");
//        try {
//            String diretorEncontrado = diretorService.consultarDiretor(1).getNome();
//            System.out.println("O nome do diretor encontrado pela id é " + diretorEncontrado);
//        } catch (InvalidArgumentsExceptions e) {
//            System.out.println(e.getMessage());
//        }
    }

}
