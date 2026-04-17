package app;

import entities.ContaBancaria;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Ben-vendo ***");
        System.out.println("*** Conta Bancária ***");

        ContaBancaria contaBancaria = new ContaBancaria(1,"Daniel",100);

        contaBancaria.verificarSaldo();
        contaBancaria.levantar(50);
        contaBancaria.deposito(250);
        contaBancaria.verificarSaldo();
    }
}