package model.interfaces;

public abstract class Cordas implements Instrumento {
    @Override
    public void tocar(String nota) {
        vibrar(nota);
    }

    public abstract void vibrar(String nota);
}
