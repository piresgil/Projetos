/*
 * @ Daniel Gil
 */

package exerciciosFinais;

import java.util.Locale;
import java.util.Scanner;

public class exercicio05 {
    /*
     * Com base na tabela abaixo, escreva um programa que leia o código de um item e
     * a quantidade deste item.
     * A seguir, calcule e mostre o valor da conta a pagar
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = 'n';
        // while (sair != 's') {

        System.out.println();
        System.out.println("-----Inicio-----");

        int codigo, quant;
        double preco;
        System.out.println("---Digite o Codigo seguido da produto:");
        codigo = sc.nextInt();
        quant = sc.nextInt();

        switch (codigo) {

            case 1:
                preco = 4.00 * quant;
                System.out.printf("1 - Cachorro Quente: $%.2f%n", preco);
                break;
            case 2:
                preco = 4.50 * quant;
                System.out.printf("2 - X-Salada: $%.2f%n", preco);
                break;
            case 3:
                preco = 5.00 * quant;
                System.out.printf("3 - X-Bacon: $%.2f%n", preco);
                break;
            case 4:
                preco = 2.00 * quant;
                System.out.printf("4 - Torrada Simples: $%.2f%n", preco);
                break;
            case 5:
                preco = 1.50 * quant;
                System.out.printf("4 - Refrigerante: $%.2f%n", preco);
                break;
        }
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        sc.close();
    }
    // }
}