/*
 * @ Daniel Gil
 */

package entities;

public class Account {
    /*
     *
     */
    private int number;
    private String holder;
    private double balance;

    // CONSTRUCTOR
    public Account(int number, String holder, double inicialDeposit) {
        this.number = number;
        this.holder = holder;
        Deposit(inicialDeposit);// caso a regra do banco mude apenas tem alteração noo metodo
    }

    // SOBECARGA
    public Account(int number, String holder) {
        this.number = number;
        this.holder = holder;
    }

    // GETTERS E SETTERS
    public int getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    // METODOS
    // DEPOSIT
    public void Deposit(double amount) {
        this.balance += amount;
    }

    // WITHDRAW
    public void withdraw(double amount) {
        this.balance -= amount + 5.00;
    }

    // TOSTRING
    public String toString() {
        return "Account: "
                + number
                + ", Holder: "
                + holder
                + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}