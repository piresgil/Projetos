/*
 * @ Daniel Gil
 */

package exerciciosFixacao.exe07_AbaixoMedia;

import java.util.Locale;
import java.util.Scanner;

public class Exe07_AbaixoMedia {
    /*
     * Faça um programa para ler dois vetores A e B, contendo N elementos cada. Em
     * seguida, gere um
     * terceiro vetor C onde cada elemento de C é a soma dos elementos
     * correspondentes de A e B. Imprima
     * o vetor C gerado.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de elementos para o vetor: ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        double[] vetorDouble = new double[n];

        for (int i = 0; i < vetorDouble.length; i++) {
            System.out.print("---Digite um nº: ");
            vetorDouble[i] = sc.nextDouble();
        }

        double soma = 0;
        for (int i = 0; i < vetorDouble.length; i++) {
            soma += vetorDouble[i];
        }
        double avg = soma / n;
        System.out.println();
        System.out.printf("MÉDIA DO VETOR = %.3f%n", avg);

        System.out.println("ELEMENTOS ABAIXO DA MÉDIA:");
        for (int i = 0; i < vetorDouble.length; i++) {
            if (vetorDouble[i] < avg) {
                System.out.println(vetorDouble[i]);
            }
        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}