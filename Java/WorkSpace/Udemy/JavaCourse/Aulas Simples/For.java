/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

public class For {
    /*
     * Fazer um programa para ler um número inteiro N e a altura de N
     * pessoas. Armazene as N alturas em um vetor. Em seguida, mostrar a
     * altura média dessas pessoas.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de alturas: ");
        int n = sc.nextInt();

        double[] vect = new double[n];

        for (int i = 0; i < n; i++) { // laço FOR para armazenar as alturas
            System.out.print("---Digite a altura: ");
            vect[i] = sc.nextDouble();
        }

        double soma = 0;

        for (int i = 0; i < n; i++) { // laço for para percorrer o vector e fazer a soma
            soma += vect[i];
        }

        double avg = soma / n; // fazendo a média
        
        System.out.println();
        System.out.printf("Média das alturas: %.2f%n", avg);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}


class Exemplo02 {
    /*
     * Fazer um programa para ler um número inteiro N e os dados (nome e
     * preço) de N Produtos. Armazene os N produtos em um vetor. Em
     * seguida, mostrar o preço médio dos produtos.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("---Digite o nº de produtos: ");
        int n = sc.nextInt();// var apenas para ler o numero de (produtos (neste caso))
        // depois vai substituida por vect.length os laços FOR e mesmo para fazer a
        // media.

        entities.Product[] vect = new entities.Product[n];

        for (int i = 0; i < vect.length; i++) {
            sc.nextLine();// para cnsumir o nextInt()
            System.out.print("Digite o nome: ");
            String name = sc.nextLine();
            System.out.print("Digite o preço: ");
            double price = sc.nextDouble();
            vect[i] = new entities.Product(name, price);
        }

        double soma = 0;

        for (int i = 0; i < vect.length; i++) {
            soma += vect[i].getPrice();
        }
        double avg = soma / vect.length;

        System.out.printf("O preço médio é: $ %.2f%n", avg);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}

class ForEach {
    /*
     *
     */
    public static void main(String[] args) {

        String[] vect = new String[] { "Maria", "Bob", "Alex" };
        System.out.println();
        System.out.println("----Exempo 1 FOR ----");
        for (int i = 0; i < vect.length; i++) {
            System.out.println(vect[i]);
        }
        System.out.println();
        System.out.println("----Exempo 2 FOR EACH----");

        // para cada objecto (obj), q estiver no vetor vect -> FAÇA
        for (String obj : vect) {
            System.out.println(obj);
        }
        System.out.println();
    }
}