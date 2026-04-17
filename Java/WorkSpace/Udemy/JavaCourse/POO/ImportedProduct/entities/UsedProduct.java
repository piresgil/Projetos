/*
* @ Daniel Gil
*/

package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Product;

public class UsedProduct extends Product {

    private LocalDate manufactureDate;

    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    // metodo
    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" (used), $ ");
        sb.append(price);
        sb.append((" (Manufacture date: " +
                manufactureDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")"));
        return sb.toString();
    }
}