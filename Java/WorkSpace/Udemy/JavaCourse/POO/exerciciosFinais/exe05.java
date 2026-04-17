/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exe05 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Fazer um programa para ler o código de uma peça 1, o número de peças 1, o
         * valor unitário de cada peça 1, o
         * código de uma peça 2, o número de peças 2 e o valor unitário de cada peça 2.
         * Calcule e mostre o valor a ser pago
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        @SuppressWarnings("unused")
        // codigo sugerido porque diz que as var cod1 e cod2, nao estao em uso...kkk
        int cod1, cod2, n1, n2;
        double v1, v2, total;

        System.out.println("Digite o ID, Quantidade e o valor do produto 1:");
        cod1 = sc.nextInt();
        n1 = sc.nextInt();
        v1 = sc.nextDouble();

        System.out.println("Digite o ID, Quantidade e o valor do produto 2:");
        cod2 = sc.nextInt();
        n2 = sc.nextInt();
        v2 = sc.nextDouble();

        total = ((v1 * n1) + (v2 * n2));
        System.out.printf("Valor a Pagar: %.2f", total);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}