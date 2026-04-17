/*
 *  @ Daniel Gil
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuinte;
import entities.Empresa;
import entities.Pessoa;

public class App {
    /*
    * 
    */
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("______________________________Inicio______________________________");

        System.out.print("  Enter the number of tax payers: ");
        // Hard Code int n = 1; // Hard code
        int n = sc.nextInt();

        List<Contribuinte> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println("Tax payer #1 data:");
            System.out.print("Individual or company (i/c)? ");
            // Hard Code char charResp = 'i'; // Hard code
            char charResp = sc.next().charAt(0);
            System.out.print("Name: ");
            // Hard Code String name = "Daniel"; // Hard Code
            String name = sc.next();
            sc.nextLine();// queima linha
            System.out.print("Anual income: ");
            // Double renda = 400000.00;
            // Hard Code Double renda = 50000.00;
            Double renda = sc.nextDouble();

            if (charResp == 'i' || charResp == 'I') {

                System.out.print("Health expenditures: ");
                // Hard Code Double saude = 2000.00; // Hard Code
                Double saude = sc.nextDouble();
                Contribuinte pessoa = new Pessoa(name, renda, saude);

                list.add(pessoa);

            } else if (charResp == 'c' || charResp == 'C') {

                System.out.print("Number of employees: ");
                // Hard Code int nrFuncionarios = 25; // Hard Code
                int nrFuncionarios = sc.nextInt();

                Contribuinte empresa = new Empresa(name, renda, nrFuncionarios);
                list.add(empresa);
            }

        }
        System.out.println();
        System.out.println("TAXES PAID:");

        for (Contribuinte c : list) {
            System.out.print(c.getName());
            System.out.printf(" : $ %.2f > $ %.2f%n", c.getRenda(), c.tax());
        }
        System.out.println();

        Double value = 0.0;
        System.out.print("TOTAL TAXES: ");
        for (Contribuinte c : list) {
            value += c.tax();
        }
        System.out.printf("%.2f $ %n", value);

        System.out.println("______________________________Final______________________________");
        sc.close();
    }
}