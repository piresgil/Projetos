/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Scanner;

public class exercicio04 {
    /*
     * Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do
     * jogo, sabendo que o mesmo pode
     * começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e
     * máxima de 24 horas.
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int hi, hf, duracao;

        System.out.println("---Digite a hora inicial e a hora final do jogo:");
        hi = sc.nextInt();
        hf = sc.nextInt();
        /*
         * LOGICA:
         * SE a hora inicial for menor que a hora final,
         * passa na condição e a var duracao asume a
         * subtraçao da hora final com a hora inicial.
         * 
         * MAS SE a hora final for maior que a hora inicial:
         * a var duracao assume 24h(de 1 dia)
         * e subtrai a soma da hora inicial com a hora final
         */
        if (hi < hf) {
            duracao = hf - hi;
        } else {
            duracao = 24 - (hi + hf);
        }
        System.out.println("o jogo durou " + duracao + " horas(s)");
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}