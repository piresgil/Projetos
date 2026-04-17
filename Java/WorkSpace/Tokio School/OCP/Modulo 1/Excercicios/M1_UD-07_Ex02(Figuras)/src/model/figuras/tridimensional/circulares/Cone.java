package model.figuras.tridimensional.circulares;

import model.Figura;
import model.FiguraCircular;

public class Cone extends Figura implements FiguraCircular {
    private static final double PI = Math.PI;
    private double raio;

    public Cone(double raio, double altura) {
        super(0, 0, altura);
        this.raio = raio;
    }

    @Override
    public double area() {
        return (PI * raio * getAltura()) + (PI * Math.pow(getRadio(), 2));
    }

    @Override
    public double volume() {
        return (1.0 / 3.0) * PI * Math.pow(raio, 2) * getAltura();
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