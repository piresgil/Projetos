/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Scanner;

public class exercicio01 {
    /*
     * Fazer um programa para ler um número inteiro, e depois dizer se este número é
     * negativo ou não.
     */

    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int x;
        System.out.print("---Digite um nº: ");
        x = sc.nextInt();

        if (x < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Não Negativo");
        }
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}