
/*
 * @ Daniel Gil
 */
package exerciciosFixacao.exe03_Alturas;

import java.util.Locale;
import java.util.Scanner;

import exerciciosFixacao.exe03_Alturas.entities.Pessoa;

public class Exe03_Alturas {
    /*
     * Fazer um programa para ler nome, idade e altura de N pessoas, conforme
     * exemplo. Depois, mostrar na
     * tela a altura média das pessoas, e mostrar também a porcentagem de pessoas
     * com menos de 16 anos,
     * bem como os nomes dessas pessoas caso houver.
     * 
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite nº de pessoas: ");
        int n = sc.nextInt();

        Pessoa pessoa[] = new Pessoa[n];

        for (int i = 0; i < pessoa.length; i++) {
            sc.nextLine();// para cnsumir o nextInt()
            System.out.println("---Dados da " + (i + 1) + "ª pessoa:");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.print("Altura: ");
            double altura = sc.nextDouble();
            pessoa[i] = new Pessoa(name, idade, altura);
        }
         
        /* Laço FOR para fazersoma das alturas para se achar a media */
        double soma = 0;
        for (int i = 0; i < pessoa.length; i++) {
        soma += pessoa[i].getAltura();
        }
        double avg = soma / n;
        System.out.println();
        System.out.printf("A Média de Alturas é: %.2f%n", avg);


        /* Laço FOR para fazer uma contagem para calcular a percentagem */
        int cont = 0;
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getIdade() < 16) {
                cont = cont + 1;
            }
        }
        /* FORMULA PARA CALCULAR/mostrar UMA PERCENTAGEM */
        double percent = cont * 100.0 / n;
        /* FORMULA PARA CALCULAR UMA PERCENTAGEM */
        System.out.printf("Pessoas com mais de 16 anos: %.1f%%%n", percent);
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getIdade() < 16) {
                System.out.println(pessoa[i].getName());
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