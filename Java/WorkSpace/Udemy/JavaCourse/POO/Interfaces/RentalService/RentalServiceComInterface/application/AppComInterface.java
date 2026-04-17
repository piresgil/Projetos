/*
 *  @ Daniel Gil
 */

package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class AppComInterface {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        /*
         * Enter rental data
         * Car model: Civic
         * Pickup (dd/MM/yyyy hh:mm): 25/06/2018 10:30
         * Return (dd/MM/yyyy hh:mm): 27/06/2018 11:40
         * Enter price per hour: 10.00
         * Enter price per day: 130.00
         * INVOICE:
         * Basic payment: 390.00
         * Tax: 58.50
         * Total payment: 448.50
         */

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String model = "Civic"; // sc.nextLine();
        System.out.println(model);

        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        // LocalDateTime start = LocalDateTime.parse("sc.netx()", fmt);
        LocalDateTime start = LocalDateTime.parse("25/06/2018 10:30", fmt);
        System.out.println(start);

        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        // LocalDateTime finish = LocalDateTime.parse("sc.netx()", fmt);
        LocalDateTime finish = LocalDateTime.parse("25/06/2018 14:40", fmt);
        // LocalDateTime finish = LocalDateTime.parse("27/06/2018 11:40", fmt);
        System.out.println(finish);

        CarRental cr = new CarRental(start, finish, new Vehicle(model));

        System.out.print("Enter price per hour: ");
        // double pricePerHour = sc.nextDouble();
        double pricePerHour = 10.00;
        System.out.println(pricePerHour);

        System.out.print("Enter price per day: ");
        // double pricePerDay = sc.nextDouble;
        double pricePerDay = 130.00;
        System.out.println(pricePerDay);

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println();

        System.out.println("INVOICE:");
        System.out.println("Basic payment: " + cr.getInvoice().getBasicPayment());

        System.out.println("Tax: " + cr.getInvoice().getTax());

        System.out.println("Total payment: " + cr.getInvoice().getTotalPayment());

        sc.close();
        System.out.println("---Final---");
    }
}