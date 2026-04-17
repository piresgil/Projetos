/*
 * @ Daniel Gil
 */

package entities;

public class Product {
    /*
     * Class referente ao Produto
     */
    public String name;
    public double price;
    public int quantity;

    public double TotalValueInStock() {
        return price * quantity;
    }

    public void AddProducts(int quantity) {
        // this é referente a var da class, e nao deste escopo
        this.quantity += quantity;
    }

    public void RemoveProducts(int quantity) {
        this.quantity -= quantity;
    }

    public String toString() {
        return name
                + " $ "
                // Formatação tipo Printf
                + String.format("%.2f", price)
                + ", "
                + quantity
                + " units, Total: $ "
                // Formatação tipo Printf
                + String.format("%.2f", TotalValueInStock());
    }
}