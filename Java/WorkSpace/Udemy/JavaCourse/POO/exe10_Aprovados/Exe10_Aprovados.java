/*
 * @ Daniel Gil
 */

package exerciciosFixacao.exe10_Aprovados;

import java.util.Locale;
import java.util.Scanner;

import exerciciosFixacao.exe10_Aprovados.entities.Aluno;

public class Exe10_Aprovados {
    /*
     * Fazer um programa para ler um conjunto de nomes de pessoas e suas respectivas
     * idades. Os nomes
     * devem ser armazenados em um vetor, e as idades em um outro vetor. Depois,
     * mostrar na tela o nome
     * da pessoa mais velha.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de Alunos: ");
        int n = sc.nextInt();
        sc.nextLine();// QUEIMA LINHA

        Aluno[] aluno = new Aluno[n];

        for (int i = 0; i < aluno.length; i++) {
            System.out.println("---Digite o NOME, primeira NOTA e segunda NOTA " + (i + 1) + "º Aluno:");
            System.out.print("---Nome: ");
            String name = sc.nextLine();
            System.out.print("---1ª Nota: ");
            double nota1 = sc.nextDouble();
            System.out.print("---2ª Nota: ");
            double nota2 = sc.nextDouble();
            sc.nextLine();
            aluno[i] = new Aluno(name, nota1, nota2);
        }

        System.out.println("Alunos APROVADOS:");

        for (int i = 0; i < aluno.length; i++) {
            double media = aluno[i].getMedia();
            if (media >= 6.0) {
                System.out.println(aluno[i].getName());
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
