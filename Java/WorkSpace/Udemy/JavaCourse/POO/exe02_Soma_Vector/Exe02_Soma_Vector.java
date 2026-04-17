/*
 * @ Daniel Gil
 */
package exerciciosFixacao.exe02_Soma_Vector;

import java.util.Locale;
import java.util.Scanner;

public class Exe02_Soma_Vector {
    /*
     * Faça um programa que leia N números reais e armazene-os em um vetor. Em
     * seguida:
     * - Imprimir todos os elementos do vetor
     * - Mostrar na tela a soma e a média dos elementos do vetor
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
        int n = sc.nextInt();// var apenas para ler o numero de (produtos (neste caso))
        // depois vai substituida por vect.length os laços FOR e mesmo para fazer a
        // media.
        double vect[] = new double[n];

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();// para cnsumir o nextInt()
            System.out.print("Digite um nº: ");
            vect[i] = sc.nextDouble();
        }

        System.out.println();
        System.out.print("valores: ");

        for (int i = 0; i < vect.length; i++) {//FOR para mostrar os valores
            System.out.print(vect[i] + " ");
        }
        System.out.println();
        System.out.print("Soma: ");
        double soma = 0;
        for (int i = 0; i < vect.length; i++) {//FOR paraa soma dos valores
            soma += vect[i];
        }
        System.out.print(soma);

        System.out.println();
        System.out.print("Média: ");
        double media = soma / n;// formula para a media
        System.out.print(media);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}
