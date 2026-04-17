/*
* @ Daniel
*/
package exerciciosFixacao.exe04_NumerosPares;

import java.util.Locale;
import java.util.Scanner;

public class Exe04_NumerosPares {
    /*
     * Faça um programa que leia N números inteiros e armazene-os em um vetor. Em
     * seguida, mostre na
     * tela todos os números pares, e também a quantidade de números pares.
     * 
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de Numeros: ");
        int n = sc.nextInt();// var apenas para ler o numero de (produtos (neste caso))
        // depois vai substituida por vect.length os laços FOR e mesmo para fazer a
        // media.
        int vect[] = new int[n];

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();// para cnsumir o nextInt()
            System.out.print("Digite um nº: ");
            vect[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Numeros Pares:");
        int cont = 0;
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] % 2 == 0) {
                cont += 1;
                System.out.print(vect[i] + " ");
            }
        }
        System.out.println();
        System.out.println("Quantidade de pares = " + cont);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
