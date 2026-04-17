/*
 * @ Daniel Gil
 */
package exerciciosFixacao.exe06_SomaVetores;

import java.util.Locale;
import java.util.Scanner;

public class Exe06_SomaVetores {
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

        System.out.print("---Digite o nº de valores para cada vetor: ");
        int n = sc.nextInt();
        sc.nextLine();// Queima linha
        int[] vetorA = new int[n];
        int[] vetorB = new int[n];

        System.out.println("Digite os valores do vetor A:");
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = sc.nextInt();
        }

        System.out.println("Digite os valores do vetor B:");
        for (int i = 0; i < vetorB.length; i++) {
            vetorB[i] = sc.nextInt();
        }
        System.out.println("valor resultante: ");
        for (int i = 0; i < n; i++) {
            int soma = vetorA[i] + vetorB[i];
            System.out.println(soma);
        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
