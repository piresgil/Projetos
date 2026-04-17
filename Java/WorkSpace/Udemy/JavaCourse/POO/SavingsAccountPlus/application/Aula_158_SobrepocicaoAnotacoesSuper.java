/*
* @ Daniel Gil
*/

package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingAccount;

public class Aula_158_SobrepocicaoAnotacoesSuper {
    /*
    *
    */
    public static void main(String[] args) throws Exception {

        Account acc1 = new Account(1001, "Alex", 1000.00);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());// REGRA DE NEGOCIO DO METODO (CLASS BASE (5.0 TAXA))

        Account acc2 = new SavingAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());// REGRA DE NEGOCIO DO METODO DA
        // (SUB CLASS(SAVINGS ACOUNT(NAO COBRA TAXA)))

        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc3.withdraw(200.0);// SUPER METODO
        System.out.println(acc3.getBalance());// REGRA DE NEGOCIO DO METODO DA
        // (SUB CLASS(SAVINGS ACOUNT(cobra +2.0 de taxa
        // E AINDA RECEBEU NO METODO SUPER OS +5.0 DE TAXA)))
    }
}