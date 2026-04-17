package model.figuras.tridimensional.circulares;

import model.Figura;
import model.FiguraCircular;

public class Esfera extends Figura implements FiguraCircular {
    private static final double PI = Math.PI;
    private double raio;

    public Esfera(double raio) {
        super(0, 0, 0);
        this.raio = raio;
    }

    @Override
    public double area() {
        return 4 * PI * Math.pow(raio,2);
    }

    @Override
    public double volume() {
        return (4.0 / 3.0) * PI * Math.pow(raio, 3);
    }

    @Override
    public double perimetro() {
        System.out.println("operação Invalida");
        return 0;
    }

    @Override
    public double getRadio() {
        return raio;
    }
}
