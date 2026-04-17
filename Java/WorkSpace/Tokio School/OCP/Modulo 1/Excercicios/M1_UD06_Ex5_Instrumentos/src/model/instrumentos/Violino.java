package model.instrumentos;

import model.interfaces.Cordas;

public class Violino extends Cordas {
    @Override
    public void vibrar(String nota) {
        System.out.println("vibrar... violino (nota " + nota + ")");
    }
}
