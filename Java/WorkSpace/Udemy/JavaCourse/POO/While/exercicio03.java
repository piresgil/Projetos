/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class exercicio03 {
    /*
     * Um Posto de combustíveis deseja determinar qual de seus produtos tem a
     * preferência de seus clientes. Escreva
     * um algoritmo para ler o tipo de combustível abastecido (codificado da
     * seguinte forma: 1.Álcool 2.Gasolina 3.Diesel
     * 4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4)
     * deve ser solicitado um novo código (até
     * que seja válido). O programa será encerrado quando o código informado for o
     * número 4. Deve ser escrito a
     * mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada
     * tipo de combustível, conforme
     * exemplo.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");

            int x;
            int alc = 0, gas = 0, die = 0;

            System.out.println("1. Alcool");
            System.out.println("2. Gasolina");
            System.out.println("3. Diesel");
            System.out.println("4. Sair");
            System.out.print("----digite o codigoo do produto: ");
            x = sc.nextInt();
            while (x != 4) {
                switch (x) {
                    case 1:
                        alc++;
                        break;
                    case 2:
                        gas++;
                        break;
                    case 3:
                        die++;
                        break;
                }
                System.out.println("1. Alcool");
                System.out.println("2. Gasolina");
                System.out.println("3. Diesel");
                System.out.println("4. Sair");
                System.out.print("----digite o codigo do produt: ");
                x = sc.nextInt();
            }
            System.out.println("Muito Obrigado");
            System.out.println("Alcool: " + alc);
            System.out.println("Gasolina: " + gas);
            System.out.println("Diesel: " + die);

            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}