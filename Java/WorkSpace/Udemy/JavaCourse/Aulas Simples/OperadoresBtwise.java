/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

public class OperadoresBtwise {
    /*
     * Operadores bitwise
     * Proggramaçao baixo nivel (microcontroladores, redes, arduino)
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            System.out.println("-----Operadores bitwise - DEMO-----");
            int n1 = 89;
            int n2 = 60;
            System.out.println(n1 & n2);
            System.out.println(n1 | n2);
            System.out.println(n1 ^ n2);

            System.out.println("-----Aplicação comum: verificar bit-----");

            int mask = 0b100000;// nº binario de 32 tem o 6º bit valendo 1
            System.out.print("Digite um nº para testar se o 6º Bit vale (1) ou (0): ");
            int n = sc.nextInt();
            if ((n & mask) != 0) {
                System.out.println("6th bit is true!");
            } else {
                System.out.println("6th bit is false");
            }

            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}