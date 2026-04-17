/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Scanner;

public class exercicio03 {
     /*
         * Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem
         * "Sao Multiplos" ou "Nao sao
         * Multiplos", indicando se os valores lidos são múltiplos entre si. Atenção: os
         * números devem poder ser digitados em
         * ordem crescente ou decrescente.
         */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int A, B;
        System.out.println("---Digite 2 nº:");
        A = sc.nextInt();
        B = sc.nextInt();
        // nº multiplos sao aqueles que divididos entre eles dá resto(Mod) (0)
        if (A % B == 0 || B % A == 0) {
            System.out.println("Sao nº Multiplos");
        } else {
            System.out.println("Não são nº Multiplos");
        }
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}