/*
 *  @ Daniel Gil
 */

package entities;

public class Product17 {

  private String name;
  private Double price;
  private Integer quantity;

  public Product17(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double totalValue() {
    return price * quantity;
  }
}