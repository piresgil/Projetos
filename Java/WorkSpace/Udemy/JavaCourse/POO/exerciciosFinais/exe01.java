/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Scanner;

public class exe01 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Faça um programa para ler dois valores inteiros,
         * e depois mostrar na tela a soma desses números com uma
         * mensagem explicativa, conforme exemplos.
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int x, y, soma;

        System.out.print("---Digite o 1º nrº: ");
        x = sc.nextInt();
        System.out.println();
        System.out.print("---Digite o 2º nrº: ");
        y = sc.nextInt();
        System.out.println();
        soma = x + y;
        System.out.println("---A soma dos nº digitados: " + soma);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}