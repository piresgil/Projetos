/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

public class Funcoes_Sintaxe {
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
        System.out.println("-----Funções (Sintaxe)-----");
        System.out.println("Enter three numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int higher = max(a, b, c);

        showResult(higher);
        
        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }

    // criando uma funçao para calcular o nº maior entre 3 nº
    public static int max(int x, int y, int z) {
        int aux;
        if (x > y && x > z) {
            aux = x;
        } else if (y > z) {// se cair aqui é porque (a) não e o maior dos 3, logo nao precisa verificar
                           // outra vez (a)
            aux = y;
        } else {
            aux = z;
        }
        return aux;
    }

    // funçao que nao retorna nada apenas mostra os dados
    public static void showResult(int value) {
        System.out.println("Higher " + value);
    }
}