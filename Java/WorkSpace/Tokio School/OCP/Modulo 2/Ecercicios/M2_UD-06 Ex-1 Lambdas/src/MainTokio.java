/**
 * @author Daniel Gil
 */

import java.util.function.Function;

public class MainTokio {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

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
        int result5 = function.apply(5);
        System.out.println("Fatorial de 5: " + result5);

        int result4 = function.apply(4);
        System.out.println("Fatorial de 4: " + result4);
    }
}