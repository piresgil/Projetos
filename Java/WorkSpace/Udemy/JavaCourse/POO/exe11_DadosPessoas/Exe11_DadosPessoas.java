/*
* @ Daniel Gil
*/
package exerciciosFixacao.exe11_DadosPessoas;

import java.util.Locale;
import java.util.Scanner;

import exerciciosFixacao.exe11_DadosPessoas.entities.Pessoa;

public class Exe11_DadosPessoas {
    /*
     * Tem-se um conjunto de dados contendo a altura e o gênero (M, F) de N pessoas.
     * Fazer um programa
     * que calcule e escreva a maior e a menor altura do grupo, a média de altura
     * das mulheres, e o número
     * de homens.
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

        System.out.print("---Digite o nº de Pessoas: ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        Pessoa[] pessoa = new Pessoa[n];

        for (int i = 0; i < pessoa.length; i++) {
            System.out.print("---Altura da " + (i + 1) + "º pessoa: ");
            double altura = sc.nextDouble();
            System.out.print("---Genero: " + (i + 1) + "º pessoa: ");
            char genero = sc.next().charAt(0);
            sc.nextLine();
            pessoa[i] = new Pessoa(altura, genero);
        }

        System.out.print("MENOR Altura: ");
        double alt = pessoa[0].getAltura();
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getAltura() < alt) {
                alt = pessoa[i].getAltura();
            }
        }
        System.out.println(alt);

        System.out.print("MAIOR Altura: ");
        alt = pessoa[0].getAltura();
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getAltura() > alt) {
                alt = pessoa[i].getAltura();
            }
        }
        System.out.println(alt);

        double media = 0.0;
        double soma = 0.0;
        int cont = 0;
        System.out.print("Média das Alturas das MULHERES: ");
        for (int i = 0; i < pessoa.length; i++) {

            if (pessoa[i].getGenero() == 'F' || pessoa[i].getGenero() == 'f') {
                soma = soma + pessoa[i].getAltura();
                cont += 1;
            }
        }
        media = soma / cont;
        System.out.printf("%.2f%n",media);

        cont = 0;
        System.out.print("nº HOMENS: ");
        for (int i = 0; i < pessoa.length; i++) {
            if (pessoa[i].getGenero() == 'M' || pessoa[i].getGenero() == 'm') {
                cont += 1;
            }
        }
        System.out.println(cont);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
