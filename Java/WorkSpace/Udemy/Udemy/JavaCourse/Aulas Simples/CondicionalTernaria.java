package application;/*
 * @ Daniel Gil
 */

import java.util.Scanner;

public class CondicionalTernaria {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Expressão condicional ternária
         * Estrutura opcional ao if-else quando se deseja decidir
         * um VALOR com base em uma condição.
         */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();
        System.out.println("Expemplo 1 com if e else");
        double preco = 34.5;
        double desconto;
        if (preco < 20.0) {
            desconto = preco * 0.1;
            System.out.println(desconto);
        } else {
            desconto = preco * 0.05;
            System.out.println(desconto);
        }

        System.out.println();
        System.out.println("Expemplo 2 (Expreção Ternária)");
        System.out.print("---Digite o preço: ");
        Scanner sc = new Scanner(System.in);
        double preco2 = sc.nextDouble();
        /*
         * Sintaxe:
         * ( condição ) ? valor_se_verdadeiro : valor_se_falso
         */
        double desconto2 = (preco2 < 20.0) ? preco2 * 0.1 : preco2 * 0.05;
        System.out.printf("o desconto é de: %.3f", desconto2);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}