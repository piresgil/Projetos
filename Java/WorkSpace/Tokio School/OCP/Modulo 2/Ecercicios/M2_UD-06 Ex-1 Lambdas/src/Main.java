/**
 * @author Daniel Gil
 */

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        /**
         * Usando interface personalizada
         */
        NumeroFactorial numeroFactorial = (n) -> {
            int resultado = 1; // inteiro positivo
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        };
        int resultadoFinal = numeroFactorial.CalculaFactorial(5);
        System.out.println(resultadoFinal);
        /////////////////////////////////////////

        /**
         * Usando interface Function
         */
        Function<Integer, Integer> function = n -> {
            int resultado = 1; // inteiro positivo
            for (int i = 2; i <= n; i++) {
                resultado *= i;
            }
            return resultado;
        };
        int result = function.apply(4);
        System.out.println(result);
    }
}