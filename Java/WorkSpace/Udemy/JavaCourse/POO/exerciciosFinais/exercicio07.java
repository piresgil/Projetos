/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exercicio07 {
    /*
     * Leia 2 valores com uma casa decimal (x e y), que devem representar as
     * coordenadas
     * de um ponto em um plano. A seguir, determine qual o quadrante ao qual
     * pertence o
     * ponto, ou se está sobre um dos eixos cartesianos ou na origem (x = y = 0).
     * Se o ponto estiver na origem, escreva a mensagem “Origem”.
     * Se o ponto estiver sobre um dos eixos escreva “Eixo X” ou “Eixo Y”, conforme
     * for a
     * situação.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        double x, y;
        System.out.print("-----Digite um Valor para 'X' e 'y': ");
        x = sc.nextDouble();
        y = sc.nextDouble();

        if (x > 0 && y > 0) {
            System.out.println("Quadrante 1");
        } else if (x > 0 && y < 0) {
            System.out.println("Quadrante 2");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrante 3");
        } else if (x < 0 && y > 0) {
            System.out.println("Quadrante 4");
        } else if (x == 0 && y == 0) {
            System.out.println("Origem");
        }
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}