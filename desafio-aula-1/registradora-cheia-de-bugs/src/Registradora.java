
public class Registradora {

    public static void main(String[] args) {
//        primeiroBug();
//
//        segundoBug();
//
//        terceiroBug();
//
//        quartoBug();
//
//        quintoBug();
//
//        sextoBug();
    }

    private static double registrarItem(String item, double quantidade) {
        double precoItem = 0;

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (DataProjeto.cozinhaEmFuncionamento()) {
                    ReposicaoCozinha.reporItem(item);
                }
            }
            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        if (ItensPorQuantidade.estoqueSuficiente(item, quantidade)) {
            precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            ItensPorQuantidade.atualizarSaldoEstoque(item, quantidade);
        } else {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento()) {
                    System.out.println("Cozinha fechada!");
                    System.out.println("A quantidade de " + item + " disponível é: "
                            + ItensPorQuantidade.retornarQuantidadeEstoque(item));
                }
                precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, ItensPorQuantidade.retornarQuantidadeEstoque(item));
                ReposicaoCozinha.reporItem(item);
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);

                //Avalia se reposição foi suficiente para atender cliente, senão vende apenas o que está no estoque.
                if ("leite".equals(item) && ItensPorQuantidade.leite > quantidade){
                    precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
                }
                else if ("leite".equals(item)) {
                    System.out.println("A quantidade de leite disponível é: " + ItensPorQuantidade.retornarQuantidadeEstoque(item));
                    precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, ItensPorQuantidade.leite);
                }
                if ("cafe".equals(item) && ItensPorQuantidade.cafe > quantidade){
                    precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
                }
                else if ("cafe".equals(item)) {
                    System.out.println("A quantidade de café disponível é: " + ItensPorQuantidade.retornarQuantidadeEstoque(item));
                    precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, ItensPorQuantidade.cafe);
                }
            }
        }



        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

}
