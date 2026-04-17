/*
* @ Daniel Gil
*/

package exercicioFixacaoMatriz;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioFixacaoMatriz {
    /*
     * 
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("---Digite um nº para Colunas e para Linhas");
        int m = sc.nextInt();// colunas
        int n = sc.nextInt();// linhas

        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {// colunas
            for (int j = 0; j < n; j++) {// Linhas
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("----Matriz----");

        System.out.println("escolha um dos nºs da matriz");
        int y = sc.nextInt();
        for (int i = 0; i < m; i++) {// colunas
            for (int j = 0; j < n; j++) {// linhas
                if (mat[i][j] == y) {
                    // condições para imprimir apenas se o valor for possivel
                    // (de klk maneira o compilador reclama)
                    System.out.println("Position: " + i + ", " + j);
                    if (j > 0) {
                        System.out.println("Left: " + mat[i][(j - 1)]);
                    }
                    if (j < mat.length) {
                        System.out.println("Rigth: " + mat[i][(j + 1)]);
                    }
                    if (i > 0) {
                        System.out.println("Up: " + mat[(i - 1)][j]);
                    }
                    if (i < mat.length) {
                        System.out.println("Down: " + mat[(i + 1)][j]);
                    }
                }
            }
        }
        sc.close();
        System.out.println("--------------------FIM--------------------");
    }
}