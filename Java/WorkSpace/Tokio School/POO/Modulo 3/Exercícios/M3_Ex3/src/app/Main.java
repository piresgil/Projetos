package app;

import entities.Cao;
import entities.Gato;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Animais ***");

        Cao cao = new Cao("Boby");
        Gato gato = new Gato("Tareco");

        cao.emitirSom();
        cao.latir();

        gato.emitirSom();
        gato.miar();

    }
}