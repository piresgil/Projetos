/*
 * @ Daniel Gil
 */

package entities;

public class Product {
    /*
     * 
     */
    private String name;// private Encapsulando
    private double price;// private Encapsulando
    private int quantity;// private Encapsulando

    public Product() {
        // construtor Padrão, não e necessário para este projeto
    }

    // construtor, basicamente evita q o user crie um produto sem nome ou preço e
    // etc...
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // construtor de sobrecarga, apenas pedindo nome e price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        // quantity = 0; // poderia ficar assim mas o java ja inicia valores numericos
        // com (0)
    }

    // metodo ger set (por convenção logo depois dos construtores)
    // SET (name)
    public void setName(String name) {
        this.name = name;
    }

    // GET (name)
    public String getName() {
        return name;
    }

    // SET(price)
    public void setPrice(double price) {
        this.price = price;
    }

    // GET (price)
    public double getPrice() {
        return price;
    }

    // GET (quantity) a fim de nao deixar a quantidade inconsistente ela apenas
    // podera ser alterada atraves dos metodos addProduct() e removeProduct()
    public double getQuantity() {
        return quantity;
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