package model.instrumentos;

import model.interfaces.Cordas;

public class ContraBaixo extends Cordas {
    @Override
    public void vibrar(String nota) {
        System.out.println("vibrar... Contra Baixo (nota " + nota + ")");
    }
}
