package app;        // Pasta do ficheiro.java

import java.util.Locale;
import java.util.Scanner;

public class Estudante {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);       // Formatação ponto(.) para decimais
        Scanner sc = new Scanner(System.in);        // Scanner, Entrada de dados

        System.out.println("Digite os dados:");
        System.out.println("---Estudante---");

        // Pede e armazena dados em variaveis
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        System.out.print("Nota: ");
        float nota = sc.nextFloat();

        // Mostra os dados formatados
        System.out.printf("%nNome: %s, Idade: %d, Nota: %.2f",nome,idade,nota);

        sc.close();     // Fecha Scanner, Entrada de dados
    }
}