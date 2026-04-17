package model.instrumentos;

import model.interfaces.Sopro;

public class Saxofone extends Sopro {
    @Override
    public void soprar(String nota) {
        System.out.println("Soprar... Saxofone (nota " + nota + ")");
    }
}
