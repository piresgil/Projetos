/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exercicio07 {
    /*
     * Estrutura repetitiva "para"
     * 
     * É uma estrutura de controle que
     * repete um bloco de comandos
     * para um certo intervalo de
     * valores.
     * 
     * Quando usar: quando se sabe
     * previamente a quantidade de
     * repetições, ou o intervalo de
     * valores.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            /*
             * Fazer um programa para ler um número inteiro positivo N. O programa deve
             * então mostrar na tela N linhas,
             * começando de 1 até N. Para cada linha, mostrar o número da linha, depois o
             * quadrado e o cubo do valor, conforme
             * exemplo.
             */
            int n;
            System.out.print("---Digite um nº: ");
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println(i + " " + (i * i) + " " + (i * i * i));
            }
            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}