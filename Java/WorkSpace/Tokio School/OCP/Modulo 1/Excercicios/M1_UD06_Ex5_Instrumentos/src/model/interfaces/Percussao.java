package model.interfaces;

public abstract class Percussao implements Instrumento {
    @Override
    public void tocar(String nota) {
        toca(nota);
    }
    public abstract void toca(String nota);
}
