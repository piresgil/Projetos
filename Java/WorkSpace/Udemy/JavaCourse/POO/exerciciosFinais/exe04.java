/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exe04 {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Fazer um programa que leia o número de um funcionário,
         * seu número de horas trabalhadas, o valor que recebe por hora
         * e calcula o salário desse funcionário. A seguir,
         * mostre o número e o salário do funcionário, com duas casas decimais.
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int id, horas;
        double valorH, salario;

        System.out.print("---ID: ");
        id = sc.nextInt();
        System.out.print("---Horas de trabalho: ");
        horas = sc.nextInt();
        System.out.print("---Valor da Hora: ");
        valorH = sc.nextDouble();

        salario = horas * valorH;
        System.out.println();
        System.out.println("ID: " + id);
        System.out.printf("Salario: %.2f", salario);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}