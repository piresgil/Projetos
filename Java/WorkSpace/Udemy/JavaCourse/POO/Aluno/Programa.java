/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

import entities.Aluno;

public class Programa {
    /*
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
        Aluno aluno = new Aluno();
        System.out.println("Enter a student data:");
        aluno.name = sc.nextLine();
        aluno.trimestre1 = sc.nextDouble();
        aluno.trimestre2 = sc.nextDouble();
        aluno.trimestre3 = sc.nextDouble();

        System.out.println("FINAL GRADE = " + aluno.FinalGrade());

        if (aluno.FinalGrade() < 60.0) {
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS", aluno.MissingPoints());
        } else {
            System.out.println("PASS");
        }

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}