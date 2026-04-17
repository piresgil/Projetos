package model.figuras.bidimensional;

import model.Figura;
import model.Figura2D;

public class Retangulo extends Figura implements Figura2D {
    /**
     * Constructor com dois @param
     * se algum dos @param forem negativos aplica o method
     * "Math.abs()", converte o número para sua versão positiva.
     *
     * @param comprimento   indica a base do retângulo
     * @param largura indica a altura do retângulo
     */
    public Retangulo(double comprimento, double largura) {
        super(comprimento, largura, 0);
        if (comprimento < 0) {
            comprimento = Math.abs(comprimento);
        }
        if (largura < 0) {
            largura = Math.abs(largura);
        }
    }
    /**
     * Method Esquadria
     * Se a base for igual há altura então é um quadrado
     *
     * @param retangulo a ser comparado como um quadrado
     * @return verdadeiro se for quadrado e falso se for um retângulo
     */
    static boolean esquadria(Retangulo retangulo) {
        if (retangulo.getComprimento() == retangulo.getLargura()) {
            return true;
        }
        return false;
    }
    @Override
    public double area() {
        return getComprimento() * getLargura();
    }

    @Override
    public double volume() {
        System.out.println("operação Invalida");
        return 0;
    }

    @Override
    public double perimetro() {
        return 2 * (getComprimento() + getLargura());
    }

    @Override
    public double getRadio() {
        System.out.println("operação Invalida");
        return 0;
    }

    /**
     * Method Girar
     * Girar 90º (cambia a base pela altura)
     *
     * @return novo retângulo girado aos 90º
     */
    public Retangulo girar(Retangulo retangulo) {
        Retangulo retangulo90 = new Retangulo(retangulo.getComprimento(), retangulo.getLargura());
        retangulo90.setComprimento(retangulo.getLargura());
        retangulo90.setLargura(retangulo.getComprimento());
        return retangulo90;
    }

    @Override
    public String toString() {
        return "Retângulo: " +
                "(comprimento: " + getComprimento() +
                ", largura: " + getLargura() + ")";
    }
}
