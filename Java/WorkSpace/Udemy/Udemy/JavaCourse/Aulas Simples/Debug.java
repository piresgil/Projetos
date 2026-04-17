package application;/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class Debug {
    /*
     * DEBUG
     * seleciona a linha para debug (f9),botão drt rato sobre a class -> debug java
     * o programa roda ate essa linha,e abre o layout de debug
     * e mostra ja os valores das variaveis,para continuar
     * primir (f10) ou setp over
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double largura = sc.nextDouble();
        double comprimento = sc.nextDouble();
        double metroQuadrado = sc.nextDouble();

        double area = largura * comprimento;
        double preco = area * metroQuadrado;
        System.out.printf("AREA = %.2f%n", area);
        System.out.printf("PRECO = %.2f%n", preco);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}