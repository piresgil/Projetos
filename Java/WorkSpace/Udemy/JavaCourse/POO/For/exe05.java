
/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exe05 {
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
             * Ler um valor N. Calcular e escrever seu respectivo fatorial.
             * Fatorial de N = N * (N-1) * (N-2) * (N-3) * ... * 1.
             * Lembrando que, por definição, fatorial de 0 é 1
             */
            int n, factor = 1;
            System.out.print("---Digite a quantidade de nº: ");
            n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                factor = factor * i;
            }
            System.out.println("Factor: " + factor);

            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}