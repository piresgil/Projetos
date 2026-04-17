/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
    /*
     * Fazer um programa para ler os dados de um produto em estoque (nome, preço e
     * quantidade no estoque). Em seguida:
     * • Mostrar os dados do produto (nome, preço, quantidade no estoque, valor
     * total no estoque)
     * • Realizar uma entrada no estoque e mostrar novamente os dados do produto
     * • Realizar uma saída no estoque e mostrar novamente os dados do produto
     * Para resolver este problema, você deve criar
     * uma CLASSE conforme projeto ao lado:
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            System.out.println();

            // Product p = new Product();// construtor padrão(nao utilizado neste projeto)

            System.out.println("Enter product data:");

            System.out.print("Name: ");
            String name = sc.nextLine();// var auxiliar para construtor
            System.out.print("Price: ");
            double price = sc.nextDouble();// var auxiliar para construtor
            
            System.out.println();

            //depois da leitura dos dados entra então
            //O Constructor de sobrecarga apenas pedindo nome e price
            Product product = new Product(name, price);

            System.out.println("Product data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be added in stock: ");
            int quantity = sc.nextInt();
            product.addProducts(quantity);
            System.out.println();
            System.out.println("Updated data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be removed from stock: ");
            quantity = sc.nextInt();
            product.removeProducts(quantity);
            System.out.println();
            System.out.println("Updated data: " + product);

            System.out.println();
            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}