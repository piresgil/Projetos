/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exe02 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Faça um programa para ler o valor do raio de um círculo, e depois mostrar o
         * valor da área deste círculo com quatro
         * casas decimais conforme exemplos.
         * Fórmula da área: area = π . raio2
         * Considere o valor de π = 3.14159
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Locale.setDefault(Locale.US);// locale tem que vir 1º que o Scanner
        Scanner sc = new Scanner(System.in);

        double raio, area;

        System.out.print("---Digite o raio do circulo: ");
        raio = sc.nextDouble();
        area = Math.PI * (raio * raio);
        System.out.printf("A area do circulo é %.4f%n", area);
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}