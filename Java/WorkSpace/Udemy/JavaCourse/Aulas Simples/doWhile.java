package application;/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class doWhile {
    /*
     * Estrutura repetitiva "faça-enquanto"
     * Menos utilizada, mas em alguns casosse encaixa melhor ao problema.
     * O bloco de comandos executa pelo menos uma vez, pois a condição é
     * verificada no final.
     * 
     * 
     * Sintaxe / regra
     * do {
     * comando 1
     * comando 2
     * } while ( condição );
     * 
     * Regra:
     * Verdade: volta
     * Falso: pula fora
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        /*
         * Fazer um programa para ler uma temperatura em Celsius
         * e mostrar o equivalente em Fahrenheit
         * Fórmula: = F = ((9*cº)/5)+32
         */

        char deslogar;

        do {
            double temp;
            System.out.print("---Digite a temperatura em Cº: ");
            temp = sc.nextDouble();
            temp = ((9 * temp) / 5) + 32;
            System.out.printf("Equivalete em Fahrenheit: %.1f%n", temp);
            System.out.print("---Quer Repetir(s/n): ");
            deslogar = sc.next().charAt(0);
        } while (deslogar != 'n' && deslogar != 'N');

        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}