package model.instrumentos;

import model.interfaces.Percussao;

public class Xilofone extends Percussao {
    @Override
    public void toca(String nota) {
        System.out.println("tocar... Xilofone (nota " + nota + ")");
    }
}
