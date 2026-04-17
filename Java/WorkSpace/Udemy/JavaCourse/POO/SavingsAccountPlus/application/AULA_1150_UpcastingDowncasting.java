/*
* @ Daniel Gil
*/

package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class AULA_1150_UpcastingDowncasting {
    /*
    * 
    */
    public static void main(String[] args) throws Exception {

        // Account acc = new Account(1001, "Alex", 0.0);
        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);

        // UPCASTING

        // posso atribuir sub classes atravez da classe base (Account)
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
        Account acc3 = new SavingAccount(1004, "Ana", 0.0, 0.01);
        acc1.getBalance();
        acc2.getBalance();
        acc3.getBalance();

        // DOWNCASTING

        // para atribuir a SUB classes para a classe base (Account)
        // precisa de atribuir um downCasting
        BusinessAccount acc4 = (BusinessAccount) acc2;
        acc4.load(100.0);

        // ERRO O COMPILADOR NAO RECONHECE,
        // MAS EM TEMPO DE EXECUÇÃO DÁ ERRO

        // BusinessAccount acc5 = (BusinessAccount) acc3;

        // uma forma de fazer o downcast, e condicionar e fazer
        // o downcast para a espectiva sub class
        // tem que se tratar esta exepção com condicinais

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount) acc3;
            acc5.load(200.0);
            System.out.println("Loan!");
        }

        if (acc3 instanceof SavingAccount) {
            SavingAccount acc5 = (SavingAccount) acc3;
            acc5.updateBalance();
            System.out.println("Update!");

        }
    }
}