package model;
/**
 * Class Carta
 */

import model.enuns.Naipe;
import model.enuns.Numero;

public class Carta {
    private final Naipe naipe;
    private final Numero numero;

    public Carta(Naipe naipe, Numero numero) {
        this.naipe = naipe;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return naipe.getAbreviatura() + "" + numero.getAbreviatura();
    }
}
