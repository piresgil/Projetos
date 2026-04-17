/*
 *  @ Daniel Gil
 */

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class App {
    /*
     * Uma empresa possui funcionários próprios e terceirizados.
     * Para cada funcionário, deseja-se registrar nome, horas
     * trabalhadas e valor por hora. Funcionários terceirizado
     * possuem ainda uma despesa adicional.
     * O pagamento dos funcionários corresponde ao valor da hora
     * multiplicado pelas horas trabalhadas, sendo que os
     * funcionários terceirizados ainda recebem um bônus
     * correspondente a 110% de sua despesa adicional.
     * Fazer um programa para ler os dados de N funcionários (N
     * fornecido pelo usuário) e armazená-los em uma lista. Depois
     * de ler todos os dados, mostrar nome e pagamento de cada
     * funcionário na mesma ordem em que foram digitados.
     * Construa o programa conforme projeto ao lado. Veja
     * exemplo na próxima página
     */
    public static void main(String[] args) throws Exception {

        System.out.println("___________________________Start___________________________");

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Outsourced (y/n)? ");
            char charOut = sc.next().charAt(0);
            System.out.println("Employee #" + (i + 1) + " data:");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (charOut == 'Y' || charOut == 'y') {
                System.out.print("Additional charge: ");
                double addicionalCharge = sc.nextDouble();

                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, addicionalCharge);
                emp.payment();
                list.add(emp);
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);
                emp.payment();
                list.add(emp);
            }
        }
        System.out.println();
        System.out.println("PAYMENTS:");
        for (Employee e : list) {
            System.out.println(e);
        }

        sc.close();
        System.out.println("___________________________End___________________________");
    }
}
