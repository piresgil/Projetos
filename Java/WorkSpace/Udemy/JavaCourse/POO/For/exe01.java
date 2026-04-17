/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exe01 {
    /*
     * Estrutura repetitiva "para"
     * 
     * É uma estrutura de controle que
     * repete um bloco de comandos
     * para um certo intervalo de
     * valores.
     * 
     * Quando usar: quando se sabe
     * previamente a quantidade de
     * repetições, ou o intervalo de
     * valores.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        /*
         * Leia um valor inteiro X (1 <= X <= 1000). Em seguida mostre os ímpares de 1
         * até X, um valor por linha, inclusive o
         * X, se for o caso.
         */
        int x;

        System.out.print("---Digite o nº entre: 1 e 1000: ");
        x = sc.nextInt();
        for (int i = 0; i <= x; i++) {
            /*
             * condiçao par/impar feita na var i,
             * porque é ela que é incrementada e podefazer a contagem.
             */
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}