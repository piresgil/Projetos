package application;/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class AtribuicaoCumulativaSintaxeOpcional {
    /*
    *
    */
    public static void main(String[] args) {

        /*
         * Uma operadora de telefonia cobra R$ 50.00 por um plano básico que
         * dá direito a 100 minutos de telefone. Cada minuto que exceder a
         * franquia de 100 minutos custa R$ 2.00. Fazer um programa para ler a
         * quantidade de minutos que uma pessoa consumiu, daí mostrar o valor
         * a ser pago.
         */
        
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();
        System.out.println("exemplo 1");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite nº de Horas: ");
        int minutos = sc.nextInt();

        double conta = 50.0;
        if (minutos > 100) {
            conta = conta + (minutos - 100) * 2.0;// sintaxe de Atribuição Cumulativa
        }
        System.out.printf("Total a pagar: $%.2f%n", conta);
        /*
         * Operadores de atribuição cumulativa
         * a += b; a = a + b;
         * a -= b; a = a - b;
         * a *= b; a = a * b;
         * a /= b; a = a / b;
         * a %= b; a = a % b;
         */
        System.out.println("exemplo 2 com operadores cumulativos");
        double conta2 = 50.0;
        if (minutos > 100) {
            conta2 += (minutos - 100) * 2.0;// sintaxe de Atribuição Cumulativa
        }
        System.out.printf("Total a pagar: $%.2f", conta2);
        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}