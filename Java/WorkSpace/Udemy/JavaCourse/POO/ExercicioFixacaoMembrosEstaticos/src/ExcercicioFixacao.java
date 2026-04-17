/*
 * @ Daniel Gil
 */

package exercicioFixacao.src;

import java.util.Locale;
import java.util.Scanner;

import exercicioFixacao.src.entities.CurrencyConverter;

public class ExcercicioFixacao {
    /*
     * Faça um programa para ler a cotação do dólar, e depois um valor em dólares a
     * ser comprado por
     * uma pessoa em reais. Informar quantos reais a pessoa vai pagar pelos dólares,
     * considerando ainda
     * que a pessoa terá que pagar 6% de IOF sobre o valor em dólar. Criar uma
     * classe CurrencyConverter
     * para ser responsável pelos cálculos.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("What is the dollar price? ");
        CurrencyConverter.real = sc.nextDouble();

        System.out.print("How many dollars will be bought? ");
        CurrencyConverter.quantity = sc.nextDouble();

        System.out.printf("Amount to be paid in reais = %.2f%n",
                CurrencyConverter.Converter(CurrencyConverter.real, CurrencyConverter.quantity));

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
