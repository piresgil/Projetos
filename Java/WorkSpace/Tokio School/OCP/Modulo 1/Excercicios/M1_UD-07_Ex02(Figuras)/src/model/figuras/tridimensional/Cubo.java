package model.figuras.tridimensional;

import model.Figura;
import model.Figura3D;

public class Cubo extends Figura implements Figura3D {

    public Cubo(double aresta) {
        super(aresta, 0, 0);
    }

    @Override
    public double area() {
        return 6 * Math.pow(getComprimento(), 2);
    }

    @Override
    public double volume() {
        return Math.pow(getComprimento(), 3);
    }

    @Override
    public double perimetro() {
        return 12 * getComprimento();
    }

    @Override
    public double getRadio() {
        System.out.println("operação Invalida");
        return 0;
    }
}
