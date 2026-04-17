/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exercicio06 {
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
            /* Ler um número inteiro N e calcular todos os seus divisores */
            int n;
            System.out.print("---Digite um nº: ");
            n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println(i);
                }
            }
            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}
