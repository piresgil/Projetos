/*
* @ Daniel
*/
package exerciciosFixacao.exe05_MaiorPosicao;

import java.util.Locale;
import java.util.Scanner;

public class Exe05_MaiorPosicao {
    /*
     * Faça um programa que leia N números reais e armazene-os em um vetor. Em
     * seguida, mostrar na tela
     * o maior número do vetor (supor não haver empates). Mostrar também a posição
     * do maior elemento,
     * considerando a primeira posição como 0 (zero).
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

        System.out.print("---Digite o nº de Numeros: ");
        int n = sc.nextInt();

        int posmaior;
        double maior;// var que vai receber(APONTAR) o vetor na posiçao[0]

        double[] vetor = new double[n];

        sc.nextLine();// para consumir o nextInt()
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Digite um nº: ");
            vetor[i] = sc.nextDouble();
        }

        maior = vetor[0];// vai receber os dados do vetor na posiçao [0]
        posmaior = 0;// começa com (0), pq do vetor porque vai indicar no laço FOR se atender ha condiçao IF

//VER EM DEBUG
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > maior) {//testa a condiçao de maior
                maior = vetor[i];//assim que atender atribui esses dados na var maior
                posmaior = i;// tal como aqui (i) é a pociçao actual do vetor, entao atriui a pociçao na var
            }
        }
        
	    System.out.printf("MAIOR VALOR = %.1f\n", maior);
	    System.out.printf("POSICAO DO MAIOR VALOR = %d\n", posmaior);

        System.out.println();

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }

}