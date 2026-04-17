/*
 *  @ Daniel Gil
*/

package application;

import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class app {
    /*
    * 
    */
    public static void main(String[] args) {

        // CLASS FICOU ABSTRACT//Account acc1 = new Account(1001, "Francisca", 1000.0);

        Account acc2 = new SavingAccount(1002, "Ana", 1000.0, 0.01);
        Account acc3 = new BusinessAccount(1003, "Elisa", 1000.0, 500.0);

        System.out.println(acc2);
        System.out.println(acc3);
        System.out.println();

        System.out.println("---Demo: suponha que você queira:");
        System.out.println("• Totalizar o saldo de todas as contas.");
        System.out.println("• Depositar 10.00 em todas as contas.");

        List<Account> list = new ArrayList<>();

        list.add(new SavingAccount(1001, "Francisca", 500.0, 0.01));
        list.add(new BusinessAccount(1002, "Elisa", 1000.0, 400.0));
        list.add(new SavingAccount(1003, "Bob", 300.0, 0.01));
        list.add(new BusinessAccount(1004, "Ana", 500.0, 500.0));

        double sum = 0;

        for (Account acc : list) {
            sum += acc.getBalance();
        }

        System.out.println("Soma: " + sum);

        for (Account acc : list) {
            acc.deposit(10.0);
        }

        for (Account acc : list) {
            System.out.printf(" Update balance for account - %d: %.2f%n", acc.getNumber(), acc.getBalance());
        }

    }
}
