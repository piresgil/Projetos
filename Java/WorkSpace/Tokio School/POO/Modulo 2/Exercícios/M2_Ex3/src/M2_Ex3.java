
import java.util.Scanner;

public class M2_Ex3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // Entrada de dados

        System.out.println("---Bem-vindo---");
        System.out.println("Um dos caminhos é seguro!");

        System.out.println("Caminho A");
        System.out.println("Caminho B");
        System.out.println("Caminho C");
        System.out.print("Qual o seu palpite (A,B,C): ");

        char res = sc.next().charAt(0); // Variavel para respostas
        System.out.println();       // Quebra de linha

        /*
         * Condicional, lê a resposta do user, e responde
         */
        if (res == 'A' || res == 'a'){  // Se a resposta for A
            System.out.println("Selecionou o caminho A");
            System.out.println("Este caminho não é seguro, deve recuar!");
        }
        if (res == 'B' || res == 'b'){  // Se a resposta for B
            System.out.println("Selecionou o caminho B");
            System.out.println("Este caminho é seguro, pode avançar!");
        }
        if (res == 'C' || res == 'c'){  // Se a resposta for C
            System.out.println("Selecionou o caminho C");
            System.out.println("Este caminho não é seguro, deve recuar!");
        }

        sc.close();     // Fecha Scanner, Entrada de dados
    }
}
