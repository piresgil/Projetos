package model.figuras.bidimensional;

import model.Figura;
import model.Figura2D;

class Circulo extends Figura implements Figura2D {
    private double raio;
    private static final double PI = Math.PI;

    /**
     * Constructor
     * usa constructor do super, que recebe um @param
     *
     * @param raio recebe apenas o raio,
     *             PI é uma constante
     */
    public Circulo(double raio) {
        super(0, 0, 0);
        this.raio = raio;
    }

    @Override
    public double area() {
        return PI * Math.pow(raio, 2);
    }

    @Override
    public double volume() {
        System.out.println("operação Invalida");
        return 0;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double getRadio() {
        return raio;
    }
}
