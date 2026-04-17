/*
 * @ Daniel Gil
 */

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
        char sair = ' ';
        while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");
            System.out.println();

            System.out.println("Enter product data:");

            Product product = new Product();

            System.out.print("Name: ");
            product.name = sc.nextLine();
            System.out.print("Price: ");
            product.price = sc.nextDouble();
            System.out.print("Quantity in stock: ");
            product.quantity = sc.nextInt();
            System.out.println();

            System.out.println("Product data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be added in stock: ");
            int quantity = sc.nextInt();
            product.AddProducts(quantity);
            System.out.println();
            System.out.println("Updated data: " + product);
            System.out.println();
            System.out.print("Enter the number of products to be adremoved from stock: ");
            quantity = sc.nextInt();
            product.RemoveProducts(quantity);
            System.out.println();
            System.out.println("Updated data: " + product);

            System.out.println();
            System.out.println("-----FIM-----");
            System.out.print("------QUER SAI? ");
            sair = sc.next().charAt(0);
        }
        sc.close();
    }
}