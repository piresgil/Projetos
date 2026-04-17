/*
* @ Daniel Gil
*/

package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;

public class App {
    /*
         * Fazer um programa para ler os dados de N
         * produtos (N fornecido pelo usuário). Ao final,
         * mostrar a etiqueta de preço de cada produto na
         * mesma ordem em que foram digitados.
         * Todo produto possui nome e preço. Produtos
         * importados possuem uma taxa de alfândega, e
         * produtos usados possuem data de fabricação.
         * Estes dados específicos devem ser
         * acrescentados na etiqueta de preço conforme
         * exemplo (próxima página). Para produtos
         * importados, a taxa e alfândega deve ser
         * acrescentada ao preço final do produto.
         * Favor implementar o programa conforme
         * projeto ao lado.
         */
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();
        /*
         * DATA
         * 
         * LocaleDate.parse("O TEXTO" ou o Scanner (sc)
         * e chama logo a formatação DatetimeFormater.ofPattern
         */
        //// HELP HARDCODE//(LocalDate date =
        //// LocalDate.parse("14/11/1987",DateTimeFormatter.ofPattern("dd/MM/yyyy"));)
        //// DATA FORMATADA

        // HELP HARDCODE// System.out.println(p.priceTag());//HELP HARDCODE
        // HELP HARDCODE// System.out.println(p1.priceTag());//HELP HARDCODE
        // HELP HARDCODE// System.out.println(p2.priceTag());//HELP HARDCODE
        // AJUDA DE HARDCODE
        // HELP HARDCODE// System.out.print("Data de fabricacao (DD/MM/YYYY): ");//HELP
        // HARDCODE
        // HELP HARDCODE// LocalDate date = LocalDate.parse(sc.next(),//HELP HARDCODE
        // HELP HARDCODE// DateTimeFormatter.ofPattern("dd/MM/yyyy"));//HELP HARDCODE

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char contractChar = sc.next().charAt(0);

            if (contractChar == 'c') {
                // HELP HARDCODE// Product p1 = new ImportedProduct("Tablet", 260.0,
                // 20.0);//HELP HARDCODE

                System.out.print("Name: ");
                String name = sc.next();

                sc.nextLine();// queima de lina
                System.out.print("Price: ");
                double price = sc.nextDouble();
                Product product = new Product(name, price);

                list.add(product);

            } else if (contractChar == 'u') {
                // HELP HARDCODE// Product p = new Product("Notebook", 11000.0);//HELP HARDCODE

                System.out.print("Name: ");
                String name = sc.next();

                sc.nextLine();// queima de lina
                System.out.print("Price: ");
                double price = sc.nextDouble();
                
                System.out.print("Manufacture date: ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Product product = new UsedProduct(name, price, date);

                list.add(product);

            } else if (contractChar == 'i') {
                // HELP HARDCODE// Product p2 = new UsedProduct("Iphone", 200.0, date);//HELP
                // HARDCODE
                System.out.print("Name: ");
                String name = sc.next();
                sc.nextLine();// queima de lina
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                double fee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, fee);

                list.add(product);
            }
        }
System.out.println("PRICE TAG:");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }
        sc.close();
    }
}
