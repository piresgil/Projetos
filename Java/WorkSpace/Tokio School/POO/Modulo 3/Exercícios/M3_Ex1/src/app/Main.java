package app;

import entities.Aluno;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // Entrada de dados

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Sistema de dados dos Alunos ***");

        int sair;

        List<Aluno> alunos = new ArrayList<>();

        do {
            System.out.println();
            System.out.println("1.Criar Aluno");
            System.out.println("2.Exibir dados do Aluno");
            System.out.println("0.Sair");
            sair = sc.nextInt();
            if (sair == 1) {
                System.out.print("Nome: ");
                String nome = sc.next();
                System.out.print("Idade: ");
                int idade = sc.nextInt();
                System.out.print("Curso: ");
                String curso = sc.next();
                System.out.print("Nr Matricula: ");
                String numeroMatricula = sc.next();
                Aluno aluno = new Aluno(nome, idade, curso, numeroMatricula);
                alunos.add(aluno);
            } else if (sair == 2) {
                for (Aluno aluno : alunos){
                    System.out.println(aluno);
                }
            }
        } while (sair != 0);
        System.out.println("*** Sair ***");
    }
}