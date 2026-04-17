/*
 * @ Daniel Gil
 */

package exerciciosFixacao.exe09_MaisVelho;

import java.util.Locale;
import java.util.Scanner;

public class Exe09_MaisVelho {
    /*
     * Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas
     * idades. Os nomes
     * devem ser armazenados em um vetor, e as idades em um outro vetor. Depois,
     * mostrar na tela o nome
     * da pessoa mais velha.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de Pessoas ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        String[] name = new String[n];
        int[] idade = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("---Dados da " + (i + 1) + "ª Pessoa");
            System.out.print("---Nome: ");
            name[i] = sc.nextLine();
            System.out.print("---Idade: ");
            idade[i] = sc.nextInt();
            sc.nextLine();
        }

        int cont = idade[0];
        String velho = name[0];

        for (int i = 0; i < name.length; i++) {
            if (idade[i] > cont) {
                cont = idade[i];
                velho = name[i];
            }
        }

        System.out.println("Pessoa mais velha: " + velho);
        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }

}
