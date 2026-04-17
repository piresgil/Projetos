
/**
 * @author Daniel Gil
 */

import model.Figura;
import model.figuras.bidimensional.Retangulo;
import model.figuras.bidimensional.Triangulo;
import model.figuras.tridimensional.circulares.Cilindro;
import model.figuras.tridimensional.circulares.Cone;
import model.figuras.tridimensional.Cubo;
import model.figuras.tridimensional.circulares.Esfera;

public class Main {

    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");

        Figura triangulo = new Triangulo(100, 100, 100);
        System.out.print("Triangulo: ");
        System.out.printf("Area: %.2f, ", triangulo.area());
        System.out.printf("Perimetro: %.2f\n", triangulo.perimetro());

        Figura retangulo = new Retangulo(100, 200);
        System.out.print("Retangulo: ");
        System.out.printf("Area: %.2f, ", retangulo.area());
        System.out.printf("Perimetro: %.2f\n", retangulo.perimetro());

        Figura cubo = new Cubo(100);
        System.out.print("Cubo: ");
        System.out.printf("Area: %.2f, ", cubo.area());
        System.out.printf("Volume: %.2f\n", cubo.volume());

        Figura esfera = new Esfera(100);
        System.out.print("Esfera: ");
        System.out.printf("Area: %.2f, ", esfera.area());
        System.out.printf("Volume: %.2f\n", esfera.volume());

        Figura cilindro = new Cilindro(100, 10);
        System.out.print("Cilindro: ");
        System.out.printf("Area: %.2f, ", cilindro.area());
        System.out.printf("Volume: %.2f\n", cilindro.volume());

        Figura cone = new Cone(100, 10);
        System.out.print("Cone: ");
        System.out.printf("Area: %.2f, ", cone.area());
        System.out.printf("Volume: %.2f\n", cone.volume());
        System.out.println();

        Figura[] array = new Figura[]{esfera, cilindro, cone};
        double totalRadios = 0;
        for (int i = 0; i < array.length; i++) {
            totalRadios += array[i].getRadio();
        }
        System.out.println("Total Radios: " + totalRadios);

    }
}
