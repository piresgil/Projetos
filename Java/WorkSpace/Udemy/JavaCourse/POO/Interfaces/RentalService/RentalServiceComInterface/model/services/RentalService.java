/*
 *  @ Daniel Gil
 */

package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

  private Double pricePerHour;
  private Double pricePerDay;

  private TaxService taxService;

  public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
    this.pricePerHour = pricePerHour;
    this.pricePerDay = pricePerDay;
    this.taxService = taxService;
  }

  public void processInvoice(CarRental carRental) {

    double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
    double hours = minutes / 60;// fração de minutos
    double basicPayment;
    if (hours <= 12) {
      basicPayment = pricePerHour * Math.ceil(hours);// arredonda para cima
    } else {
      basicPayment = pricePerDay * Math.ceil(hours / 24);// arredonda para cima
    }

    double tax = taxService.tax(basicPayment);

    carRental.setInvoice(new Invoice(basicPayment, tax));
  }
}
