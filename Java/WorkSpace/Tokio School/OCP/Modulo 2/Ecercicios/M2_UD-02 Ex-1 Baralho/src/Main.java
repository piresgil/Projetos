/**
 * @author Daniel Gil
 */

import model.Carta;
import model.enuns.Naipe;
import model.enuns.Numero;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        Carta carta = new Carta(Naipe.ESPADAS, Numero.CINCO);
        System.out.println(carta);
    }
}