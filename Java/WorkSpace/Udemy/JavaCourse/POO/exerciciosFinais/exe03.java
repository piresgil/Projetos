/*
 * @ Daniel Gil
 */
package exerciciosFinais;

import java.util.Scanner;

public class exe03 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir,
         * calcule e mostre a diferença do produto
         * de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C *
         * D).
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int A, B, C, D, dif;

        System.out.print("---Digite o nº A: ");
        A = sc.nextInt();
        System.out.println();
        System.out.print("---Digite o nº B: ");
        B = sc.nextInt();
        System.out.println();
        System.out.print("---Digite o nº C: ");
        C = sc.nextInt();
        System.out.println();
        System.out.print("---Digite o nº D: ");
        D = sc.nextInt();
        System.out.println();

        dif = (A * B - C * D);
        System.out.println("Baseada na formula (A*B-C*D) a diferença dos 4 nº é:");
        System.out.println(dif);
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}