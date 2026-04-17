package model.instrumentos;

import model.interfaces.Percussao;

public class Tambor extends Percussao {
    @Override
    public void toca(String nota) {
        System.out.println("tocar... Tambor (nota " + nota + ")");
    }
}
