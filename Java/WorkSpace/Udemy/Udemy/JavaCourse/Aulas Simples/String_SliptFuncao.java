/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

public class String_SliptFuncao {
    /*
     * Operadores bitwise
     * Proggramaçao baixo nivel (microcontroladores, redes, arduino)
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");

        System.out.println();
        System.out.println("-----Funçao Split - Strings-----");
        String s = "potato apple lemon";
        //cria um vector e separa a string segundo a condiçao (" ") um espaço no caso
        String[] word = s.split(" ");
        //vector começa em (0) armazena a 1º string ate ao espaço (" ")
        System.out.println(word[0]);
        System.out.println(word[1]);// armazena 2ª string ate ao proximo espaço (" ")
        System.out.println(word[2]);

        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}