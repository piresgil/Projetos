/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exe02 {
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
             * Leia um valor inteiro N. Este valor será a quantidade de valores inteiros X
             * que serão lidos em seguida.
             * Mostre quantos destes valores X estão dentro do intervalo [10,20] e quantos
             * estão fora do intervalo, mostrando
             * essas informações conforme exemplo (use a palavra "in" para dentro do
             * intervalo, e "out" para fora do intervalo)
             */
            int n, x, in = 0, out = 0;
            System.out.print("---Digite a quantidade de nº: ");
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print("---Digite o nº: ");
                x = sc.nextInt();
                if (x >= 10 && x <= 20) {
                    in++;
                } else {
                    out++;
                }
            }
            System.out.println(in + " IN (10,20)");
            System.out.println(out + " OUT (10,20)");

            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}