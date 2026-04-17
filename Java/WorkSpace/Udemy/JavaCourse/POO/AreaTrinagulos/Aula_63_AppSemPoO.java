/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class Aula_63_AppSemPoO {
    /*
     * Fazer um programa para ler as medidas dos lados de
     *  dois triângulos X e Y (suponha medidas  válidas).
     * Em seguida, mostrar o valor das áreas dos dois triângulos
     *  e dizer qual dos dois triângulos possui a maior área.
     * 
     * A fórmula para calcular a área de um triângulo
     *  a partir das medidas de seus lados a, b e c é
     *  a seguinte (fórmula de Heron):
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            System.out.println();

            double xA, xB, xC, yA, yB, yC;

            System.out.println("Enter the measure of triangle x:");
            xA = sc.nextDouble();
            xB = sc.nextDouble();
            xC = sc.nextDouble();
            System.out.println("Enter the measure of triangle y:");
            yA = sc.nextDouble();
            yB = sc.nextDouble();
            yC = sc.nextDouble();

            double p = (xA + xB + xC) / 2.00;
            double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

            p = (yA + yB + yC) / 2.00;
            double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

            System.out.printf("Triangle X area: %.4f%n", areaX);
            System.out.printf("Triangle Y area: %.4f%n", areaY);

            if (areaX > areaY) {
                System.out.println("larger area: X");
            } else {
                System.out.println("larger area: Y");
            }
            System.out.println();
            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}