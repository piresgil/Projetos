/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exe06 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Fazer um programa que leia três valores com ponto flutuante de dupla
         * precisão: A, B e C. Em seguida, calcule e
         * mostre:
         * a) a área do triângulo retângulo que tem A por base e C por altura.
         * b) a área do círculo de raio C. (pi = 3.14159)
         * c) a área do trapézio que tem A e B por bases e C por altura.
         * d) a área do quadrado que tem lado B.
         * e) a área do retângulo que tem lados A e B.
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double A, B, C, tri, cir, tra, qua, ret;

        System.out.println("---Digite um valor para A, B e C");
        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();

        tri = (A * C) / 2;
        cir = Math.PI * (C * C);
        tra = (A + B) * C / 2;
        qua = B * B;
        ret = A * B;

        System.out.printf("Area Triangulo: %.3f%n", tri);
        System.out.printf("Area Circulo: %.3f%n", cir);
        System.out.printf("Area Trapézio: %.3f%n", tra);
        System.out.printf("Area Quadrado: %.3f%n", qua);
        System.out.printf("Area Retangulo: %.3f%n", ret);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}