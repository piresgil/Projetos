/*
* @ Daniel Gil
*/

package entities;

import entities.Product;

public class ImportedProduct extends Product {

    private Double customsFee;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    /// metodo
    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("  $ ");
        sb.append(price);
        sb.append(" (Customs fee: $ ");
        sb.append(customsFee + ")");
        return sb.toString();
    }
}