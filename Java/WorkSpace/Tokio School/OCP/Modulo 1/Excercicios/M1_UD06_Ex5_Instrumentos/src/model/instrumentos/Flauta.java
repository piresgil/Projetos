package model.instrumentos;

import model.interfaces.Sopro;

public class Flauta extends Sopro {
    @Override
    public void soprar(String nota) {
        System.out.println("Soprar... Flauta (nota " + nota + ")");
    }
}
