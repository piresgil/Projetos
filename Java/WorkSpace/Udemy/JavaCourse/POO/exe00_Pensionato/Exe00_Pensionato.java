/*
* @ Daniel Gil
*/
package exerciciosFixacao.exe00_Pensionato;

import java.util.Locale;
import java.util.Scanner;

import exerciciosFixacao.exe00_Pensionato.entities.Room;

public class Exe00_Pensionato {
    /*
     * A dona de um pensionato possui dez quartos para alugar para estudantes,
     * sendo esses quartos identificados pelos números 0 a 9.
     * Fazer um programa que inicie com todos os dez quartos vazios, e depois
     * leia uma quantidade N representando o número de estudantes que vão
     * alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
     * N estudantes. Para cada registro de aluguel, informar o nome e email do
     * estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
     * que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
     * um relatório de todas ocupações do pensionato, por ordem de quarto,
     * conforme exemplo.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---How many rooms will be rented? ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        Room[] vect = new Room[10];

        for (int i = 0; i < n; i++) {
            System.out.println("RENT#" + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int number = sc.nextInt();
            vect[number] = new Room(name, email); // vetor fica com referencia ao numero do quarto (room)
            System.out.println();
            sc.nextLine();// QUEIMA LINHA
        }
        System.out.println();
        System.out.println("Busy Rooms:");
        for (int i = 0; i < vect.length; i++) {
            if (vect[i] != null) {
                System.out.println(i + ":  " + vect[i]);
            }
        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}