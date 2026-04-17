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
        // char sair = ' ';
        // while (sair != 's') {
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

        // depois da leitura dos dados entra então
        // O Constructor de sobrecarga apenas pedindo nome e price
        Product product = new Product(name, price);

        // product.name = "Computer" // nao compila, pois o atributo name
        // é privado da class produto, nao pode ser acessado aqui,
        // precisa metodos get e set

        product.setName("Computer");// metodo SET (setName()) (metodo SET repõe o nome passado como atributo para o
                                    // parametro assumindo assim o novo (nome)neste caso)
        System.out.println("Update Name: " + product.getName());// metodo GET (getName()) (metodo GET mostra valor do
                                                                // parametro)

        product.setPrice(1200.0);// metodo SET (setPrice()) (metodo SET repõe o preço passado como atributo para
                               // o
                               // parametro assumindo assim o novo valor (price)neste caso)
        System.out.println("Update Price: " + product.getPrice());// metodo GET (getPrice()) (metodo GET mostra valor do
                                                                  // parametro)
        System.out.println();
        System.out.println("Product data: " + product);
        System.out.println();
        System.out.print("Enter the number of products to be added in stock: ");
        int quantity = sc.nextInt();
        product.addProducts(quantity);
        System.out.println();
        System.out.println("Updated data: " + product);
        System.out.println();
        System.out.print("Enter the number of products to be Removed from stock: ");
        quantity = sc.nextInt();
        product.removeProducts(quantity);
        System.out.println();
        System.out.println("Updated data: " + product);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}