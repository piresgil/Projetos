/*
 *  @ Daniel Gil
 */

package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class App {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        /*
         * Enter contract data
         * Number: 8028
         * Date (dd/MM/yyyy): 25/06/2018
         * Contract value: 600.00
         * Enter number of installments: 3
         * Installments:
         * 25/07/2018 - 206.04
         * 25/08/2018 - 208.08
         * 25/09/2018 - 210.12
         */

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        // int number = sc.nextInt();
        int number = 8028;
        System.out.println(number);

        System.out.print("Date (dd/MM/yyyy): ");
        // LocalDate date = LocalDate.parse(sc.next(), fmt);
        LocalDate date = LocalDate.parse("25/06/2018", fmt);
        System.out.println(date);

        System.out.print("Contract value: ");
        // double contractValue = sc.nextDouble();
        double contractValue = 600.00;
        System.out.println(contractValue);

        // isntacia contract recebendo os dados do contracto
        Contract contract = new Contract(number, date, contractValue);

        System.out.print("Enter number of installments: ");
        // int numberInstallments = sc.nextInt();
        int numberInstallments = 3;
        System.out.println(numberInstallments);

        // Instacia contract service implementando a interfase (paypalsevice)
        ContractService contractService = new ContractService(new PaypalService());

        // processa os servisos do contracto com os dados obtidos
        contractService.processContract(contract, numberInstallments);

        System.out.println();
        System.out.println("--Installments:---");

        for (Installment installment : contract.getInstallment()) {
            System.out.println(installment);
        }

        System.out.println();
        sc.close();
        System.out.println("---Final---");
    }
}