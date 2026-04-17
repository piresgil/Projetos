
/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exe03 {
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
       // char sair = ' ';
       // while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            /*
             * Leia 1 valor inteiro N, que representa o número de casos de teste que vem a
             * seguir. Cada caso de teste consiste
             * de 3 valores reais, cada um deles com uma casa decimal. Apresente a média
             * ponderada para cada um destes
             * conjuntos de 3 valores, sendo que o primeiro valor tem peso 2, o segundo
             * valor tem peso 3 e o terceiro valor tem
             * peso 5.
             */
            int n;
            System.out.print("---Digite a quantidade de nº: ");
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.println("---Digite os nº para Média:");
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                double z = sc.nextDouble();
                /*
                 * sendo que o primeiro valor tem peso 2, o segundo
                 * valor tem peso 3 e o terceiro valor tem peso 5
                 * 2+3+5=10, tem de ser dividido por 10 para achar a mediae acordo
                 * com o pedido
                 */
                double media = (x * 2 + y * 3 + z * 5) / 10;

                System.out.printf("Média %.1f%n", media);
            }
            System.out.println("-----FIM-----");
       //     System.out.print("------QUER SAI? ");
       //     sair = sc.next().charAt(0);
       // }
        sc.close();
    }
}