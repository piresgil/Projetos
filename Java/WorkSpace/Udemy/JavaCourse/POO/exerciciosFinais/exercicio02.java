/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Scanner;

public class exercicio02 {
    /*
     * Fazer um programa para ler um número inteiro e dizer se este número é par ou
     * ímpar
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int x;

        System.out.print("---Digite um nº: ");
        x = sc.nextInt();
        // Nº parsao aqueles que divididos po 2, dá resto(Mod)(0)
        if (x % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}