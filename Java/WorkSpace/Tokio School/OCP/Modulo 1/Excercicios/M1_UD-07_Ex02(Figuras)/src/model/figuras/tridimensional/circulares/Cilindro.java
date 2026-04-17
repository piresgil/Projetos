package model.figuras.tridimensional.circulares;

import model.Figura;
import model.FiguraCircular;

public class Cilindro extends Figura implements FiguraCircular {
    private static final double PI = Math.PI;
    private double raio;

    public Cilindro(double raio, double altura) {
        super(0, 0, altura);
        this.raio = raio;
    }

    @Override
    public double area() {
        return (2 * PI * raio * getAltura()) + (2 * PI * Math.pow(getRadio(), 2));
    }

    @Override
    public double volume() {
        return PI * Math.pow(getRadio(), 2) * getAltura();
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
