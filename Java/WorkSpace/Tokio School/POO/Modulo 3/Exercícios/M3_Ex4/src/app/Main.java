package app;

import entities.Carro;
import entities.Moto;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Veículos ***");

        Carro carro = new Carro("Ferrari", 2020, 3);
        Moto moto = new Moto("KTM", 2022, "500cc");

        carro.apresentar();
        moto.apresentar();

    }
}