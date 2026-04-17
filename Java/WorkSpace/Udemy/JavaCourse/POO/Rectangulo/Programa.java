/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

import entities.Rectangle;

public class Programa {
    /*
     * 
     */
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Rectangle rectangle = new Rectangle();

        System.out.println("Enter rectangle width and height:");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();
        System.out.printf("AREA: %.2f%n", rectangle.Area());
        System.out.printf("PERIMETER: %.2f%n", rectangle.Perimeter());
        System.out.printf("DIAGONAL: %.2f%n", rectangle.Diagonal());

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}