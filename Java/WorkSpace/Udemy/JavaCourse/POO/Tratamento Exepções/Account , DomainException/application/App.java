/*
 *  @ Daniel Gil
 */

package application;

import model.entities.Account;
import model.exceptions.DomainException;

public class App {
    /*
     * Fazer um programa para ler os dados de uma conta bancária e depois realizar
     * um
     * saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
     * ou se não houver saldo na conta, ou se o valor do saque for superior ao
     * limite de
     * saque da conta. Implemente a conta bancária conforme projeto abaixo:
     */
    public static void main(String[] args) throws Exception {

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = 8210; // Hard Code
            System.out.println(number);// Hard Code

            System.out.print("Holder: ");
            String holder = "Daniel"; // Hard Code
            System.out.println(holder);// Hard Code

            System.out.print("Initial balance: ");
            double initialBalance = 500.0; // Hard Code
            System.out.println(initialBalance);// Hard Code

            System.out.print("Withdraw limit: ");
            double withdrawLimit = 300.0; // Hard Code
            System.out.println(withdrawLimit);// Hard Code

            System.out.print("Enter amount for withdraw: ");
            double amount = 800.0; // Hard Code
            System.out.println(amount);// Hard Code

            Account account = new Account(number, holder, initialBalance, withdrawLimit);
            account.withdraw(amount);
            account.update(withdrawLimit, amount);
            System.out.print("New balance: ");
            System.out.println(account.getBalance());
        }
        // blocos catch
        catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}