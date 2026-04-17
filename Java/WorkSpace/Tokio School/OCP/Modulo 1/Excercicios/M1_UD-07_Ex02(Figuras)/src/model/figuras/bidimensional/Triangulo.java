/*
 * @ Daniel Gil
 */

package model.figuras.bidimensional;

import model.Figura;
import model.Figura2D;

public class Triangulo extends Figura implements Figura2D {

    public Triangulo(double comprimento, double largura, double altura) {
        super(comprimento, largura, altura);
    }

    @Override
    public double area() {
        double semiPerimetro = perimetro() / 2.0;
        return Math.sqrt(semiPerimetro *
                (semiPerimetro - getComprimento()) *
                (semiPerimetro - getLargura()) *
                (semiPerimetro - getAltura()));
    }

    @Override
    public double volume() {
        System.out.println("operação Invalida");
        return 0;
    }

    @Override
    public double perimetro() {
        return getComprimento() + getLargura() + getAltura();
    }

    @Override
    public double getRadio() {
        System.out.println("operação Invalida");
        return 0;
    }
}