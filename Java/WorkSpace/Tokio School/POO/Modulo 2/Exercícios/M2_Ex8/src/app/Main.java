package app;

import entities.Conta;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Contas ***");

        Conta acc1 = new Conta("João", 1, 2000.0);
        Conta acc2 = new Conta("Maria", 2, 500.00);

        System.out.println(acc1);
        System.out.println(acc2);
        System.out.println();
        if (acc1.getQuantidade() > acc2.getQuantidade()) {
            System.out.println("*** Conta " + acc1.getNumeroConta() + " tem mais quantidade de dinheiro. ***");
        } else {
            System.out.println("*** Conta " + acc2.getNumeroConta() + " tem mais quantidade de dinheiro. ***");
        }
    }
}