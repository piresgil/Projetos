import assertsClasses.NaipesEnum;

import java.util.ArrayList;
import java.util.List;

public class MainAssert {

    // static, inicializado antes dos construtores, ou seja 1ª parte do código a ser executada
    static {
        // verificação de asserts ativos na JVM
        boolean assertsEnable = false;
        assert assertsEnable = true;
        if (!assertsEnable) {
            throw new RuntimeException("Assert deve estar ativado");
        }
    }

    public static void main(String[] args) {
        System.out.println("*** Assert ****");
        // Asserts
        // assert muito util para debugs, lança exception, funciona como uma condição
        // necessita de uma flag
        // (ir a opções de run/debug, add VM options, e colocar a flag (-ea))

        // int n = 20;
        // for (int i = 0; i < 100; i++) {
        //     System.out.println(i);
        //     assert i < n : "i nao pode ser maior que 20";
        // }

        // Asserts
        // assert Expression;
        // assert Expression : Expression

        // imprimirStringsNaoNulas(null);

        // Boas práticas
        // 1 - Não usar asserts com lógica nas app´s
        // 2 - Não usar asserts em métodos públicos
        // 3 - Quando se valida inputs em métodos públicos, deve-se usar as exceptions, referentes ao erro (IllegalArgumentException; IndexAOB; NullPointerException)
        //

        // List<String> list = new ArrayList<>();
        // assert removerNulos(list);
        // list.add("oi");

        /*
         *        int i = 3;
         *        if (i % 3 == 0) {
         *            // alguma coisa aqui
         *        } else if (i % 3 == 1) {
         *            // alguma coisa aqui
         *        } else {
         *            assert i % 3 == 2; // melhor que um comentário
         *        }
         *
         *        NaipesEnum naipe = NaipesEnum.valueOf("COPASs");
         *        switch (naipe) {
         *            case COPAS:
         *                System.out.println(naipe);
         *                break;
         *            case OUROS:
         *                System.out.println(naipe);
         *                break;
         *            case PAUS:
         *                System.out.println(naipe);
         *                break;
         *            case ESPADAS:
         *                System.out.println(naipe);
         *                break;
         *            default:
         *                // System.out.println("Não foi nenhuma das anteriores"); // se naipes estiver mal escrito (por exp) o c+odigo nem entra aqui
         *                // assert false : naipe; // boa prática
         *                // ou então:
         *                throw new AssertionError(naipe);
         *        }
         */

    }

    void foo(List<String> listaInputs) {
        for (int i = 0; i < 10; i++) {
            if (listaInputs.equals("CASA")) {
                listaInputs.remove(i);
                return;
            }
        }
        // se não existir uma String "CASA", retorna false, NUNCA VAI CHECAR ESSA LINHA
        // se existir algum código morto poderá usar um assert
        assert false;
    }

    private static void imprimirStringsNaoNulas(String input) {
        // assert input != null;
        assert input != null : "Input foi nulo; input " + input;
        // if (input != null) {
        System.out.println("esse é o input " + input);
        // }
    }

    private static Boolean removerNulos(List<String> list) {
        return true;
    }

    public static double calcularTaxaSalario(float salario) {
        // assert salario < 0 : "Salario invalido"; // não e boa prática
        if (salario <= 0) {
            throw new IllegalArgumentException("salario invalido");
        }
        return 0;
    }
}