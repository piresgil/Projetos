/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class Exe01_Negativos {
    /*
     * Faça um programa que leia um número inteiro positivo N (máximo = 10) e depois
     * N números inteiros
     * e armazene-os em um vetor. Em seguida, mostrar na tela todos os números
     * negativos lidos.
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
        if (n <= 10) {

            for (int i = 0; i < vect.length; i++) {//Laço FOR para guardar os dados no vetc
                sc.nextLine();// para cnsumir o nextInt()
                System.out.print("Digite um nº: ");
                vect[i] = sc.nextInt();
            }
            System.out.println();
            System.out.println("Numeros Negativos:");
            for (int i = 0; i < vect.length; i++) {//Laço FOR para ler os dados do vect
                if (vect[i] < 0) {//condição para imprimir anepeas os negativos
                    
                    System.out.println(vect[i]);
                }
            }
        } else {
            System.out.println();
            System.out.println("Maximo de numeros 10");
        }
        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
