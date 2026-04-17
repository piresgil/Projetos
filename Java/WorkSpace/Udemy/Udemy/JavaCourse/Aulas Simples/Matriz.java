/*
* @ Daniel Gil
*/

package application;

import java.util.Scanner;

public class Matriz {
    /* 
    * 
    */
    public static void main(String[] args) {
        System.out.print("---Digite um nº: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mat = new int[n][n];// Instanciaçao de Matriz
        System.out.println("Posições:");
        // percorrendo a matriz
        for (int i = 0; i < n; i++) {// 1º FOR colunas
            for (int j = 0; j < n; j++) {// 2º FOR linhas
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.print("Main Diagonal Principal: ");
        for (int i = 0; i < n; i++) {// 1º FOR colunas
            System.out.print(mat[i][i] + ", ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.print("Negativos: ");
        int cont = 0;
        for (int i = 0; i < n; i++) {// 1º FOR colunas
            for (int j = 0; j < mat[i].length; j++) {// 2º FOR linhas
                if (mat[i][j] < 0) {
                    cont++;
                }
            }
        }
        System.out.println(cont);

        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------");
        System.out.println("----------MATRIZ---------");
        for (int i = 0; i < n; i++) {// 1º FOR colunas
            for (int j = 0; j < mat[i].length; j++) {// 2º FOR linhas
                System.out.print("Posição: " + i + ", " + j + "  =  ");
                System.out.println(mat[i][j]);
            }
        }
        sc.close();
    }

}