/*
* @ Daniel Gil
*/
package entities;

public class SavingsAccountPlus extends SavingAccount {
    // final class em class extendida

    @Override
    public void withdraw(Double amount) {
        balance -= amount + 2.0;
    }
    // final metodo na class SavingsAccount
}
