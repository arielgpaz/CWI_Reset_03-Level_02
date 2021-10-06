public class ItensPorQuantidade {

    static double pao = 3600;
    static double torta = 4;
    static double sanduiche = 20;
    static double leite = 20;
    static double cafe = 20;

    public static double retornarQuantidadeEstoque(String item) {
        if ("pao".equals(item)) {
            return pao;
        }
        if ("sanduiche".equals(item)) {
            return sanduiche;
        }
        if ("torta".equals(item)) {
            return torta;
        }
        if ("leite".equals(item)) {
            return leite;
        }
        if ("cafe".equals(item)) {
            return cafe;
        }
        return 0;
    }

    public static void atualizarSaldoEstoque (String item, double quantidade) {
        if ("pao".equals(item)) {
            pao -= quantidade * 60;
        }
        if ("sanduiche".equals(item)) {
            sanduiche -= quantidade;
        }
        if ("torta".equals(item)) {
            torta -= quantidade / 16;
        }
        if ("leite".equals(item)) {
            leite -= quantidade;
        }
        if ("cafe".equals(item)) {
            cafe -= quantidade;
        }
    }

    public static boolean estoqueSuficiente(String item, double quantidade) {
        if ("pao".equals(item)) {
            return quantidade <= pao;
        }
        if ("sanduiche".equals(item)) {
            return quantidade <= sanduiche;
        }
        if ("torta".equals(item)) {
            return quantidade <= torta * 16;
        }
        if ("leite".equals(item)) {
            return quantidade <= leite;
        }
        if ("cafe".equals(item)) {
            return quantidade <= cafe;
        }
        return false;
    }
}
