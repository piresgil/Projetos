/*
 * @ Daniel Gil
 */

package exerciciosFixacao.exe08_MediaPares;

import java.util.Locale;
import java.util.Scanner;

public class Exe08_MediaPares {
    /*
     * Fazer um programa para ler um vetor de N números inteiros. Em seguida,
     * mostrar na tela a média
     * aritmética somente dos números pares lidos, com uma casa decimal. Se nenhum
     * número par for
     * digitado, mostrar a mensagem "NENHUM NUMERO PAR"
     * tor C gerado.
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

        int[] vetor = new int[n];

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("---Digite um nº: ");
            vetor[i] = sc.nextInt();
        }

        double soma = 0;
        int cont = 0;
        boolean par = false;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] % 2 == 0) {
                soma += vetor[i];
                cont += 1;
                par = true;
            } else {
                par = false;
            }
        }
       if (par != false) {
            double avg = soma / cont;
            System.out.println();
            System.out.printf("MÉDIA DOS Nº PARES = %.1f%n", avg);
        } else {
            System.out.println();
            System.out.println("NEHUM Nº PAR!!!");

        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}