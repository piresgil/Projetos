/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class AppPoO {
    /* Projeto em PoO (Programação orientada a Objetos) */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Triangle x, y;

        x = new Triangle();
        y = new Triangle();

        System.out.println("Enter the measure of triangle x:");
        x.a = sc.nextDouble();
        x.b = sc.nextDouble();
        x.c = sc.nextDouble();
        System.out.println("Enter the measure of triangle y:");
        y.a = sc.nextDouble();
        y.b = sc.nextDouble();
        y.c = sc.nextDouble();

        double areaX = x.area();
        double areaY = y.area();

        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);

        if (x.area() > y.area()) {
            System.out.println("larger area: X");
        } else {
            System.out.println("larger area: Y");
        }
        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}