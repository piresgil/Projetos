/*
 * @ Daniel Gil
 */

package application;

public class GetterSetterAutomatic {
    /*
     *
     */
    private String name;// private Encapsulando
    private double price;// private Encapsulando
    private int quantity;// private Encapsulando

    // gerado automaticamente(botao drt-source Action-generate construtor)
    public GetterSetterAutomatic(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // sobecarga 2 parametros(gerado auto selecionando apenas os parametros
    // pretendidos
    public GetterSetterAutomatic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // getter e setter automaticamente (botao drt-source Action-generate)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // removido do auto, setQuantity devido a regra de negocio(ja tem metodos
    // add/remove product)
    public int getQuantity() {
        return quantity;
    }

    public double TotalValueInStock() {
        return price * quantity;
    }

    public void AddProducts(int quantity) {
        // this é referente ao parametro da class, e nao o atributo deste escopo
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