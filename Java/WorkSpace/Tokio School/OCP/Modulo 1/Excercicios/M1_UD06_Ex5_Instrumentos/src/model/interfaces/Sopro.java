package model.interfaces;

public abstract class Sopro implements Instrumento {
    @Override
    public void tocar(String nota) {
        soprar(nota);
    }

    public abstract void soprar(String nota);
}
