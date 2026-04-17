/*
 * @ Daniel Gil
 */
package entities;

public class Product {
    /*
     * 
     */
    public String name;
    public double price;
    public int quantity;

    public Product() {
        // construtor Padrão, não e neceessário para este projecto
    }

    // construtor, basicamente evita q o user crie um produto sem nome ou preço e
    // etc...
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // construtor de sobecarga, apenas pedindo nome e pric
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        // quantity = 0; // poderia ficar assim mas o java ja inicia valores numericos
        // com (0)
    }

    public double TotalValueInStock() {
        return price * quantity;
    }

    public void addProducts(int quantity) {
        // this é referente a var da class, e nao deste escopo
        this.quantity += quantity;
    }

    public void removeProducts(int quantity) {
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