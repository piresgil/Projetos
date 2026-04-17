package application;/*
 * @ Daniel Gil
 */

import java.util.Scanner;

public class If_Else {
    /*
     * 
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.println("----Exp 1, sem if-----");
        System.out.println("Bom Dia");
        System.out.println("Boa Tarde");
        System.out.println("Boa Noite");
        System.out.println();
        System.out.println("----Exp 2, com if-----");

        int x = 5;

        System.out.println("Bom Dia");
        if (x < 0) { // (x=5), logo nao vai imprimir "Boa Tarde"
            System.out.println("Boa Tarde");
        } // bloco de condicinal acaba aqui por isso imprime o "Boa Noite"
        System.out.println("Boa Noite");

        System.out.println();
        System.out.println("----Exp 3, com if e entrada de dados-----");
        Scanner sc = new Scanner(System.in);

        int hora;

        System.out.print("Quantas Horas: ");

        hora = sc.nextInt();
        if (hora < 12) {
            System.out.println("Bom Dia");// quando tem apens um comando, as chaves{} do if ou else sao opcionais
        } else if (hora < 18) {
            System.out.println("Boa Tarde");
        } else {
            System.out.println("Boa Noite");
        }
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}