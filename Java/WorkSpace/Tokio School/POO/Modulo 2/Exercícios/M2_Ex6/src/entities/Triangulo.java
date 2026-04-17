package entities;

public class Triangulo {
    /*
     * Class Triangulo
     */
    public double a;
    public double b;
    public double c;


    public Triangulo(double a, double b, double c) {    // Construtor com agrgumentos
        this.a = a;
        this.b = b;
        this.c = c;
    }


    public void tipoTriangulo() {   // Metodo para validar tipo de triangulo

        if (a == b && b == c)
            System.out.println("Triangulo equilátero."); // todos lados iguais

        else if (a == b || b == c || c == a)
            System.out.println("Triangulo isósceles."); // 2 lados iguais

        else
            System.out.println("Triangulo escaleno.");  // todos lados diferentes
    }

    public double area() {  // Metodo para calcular area
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Metodo para calcular os ângulos usando a Lei dos Cossenos
    public void calculaAngulos(double a, double b, double c) {
        double anguloA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double anguloB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double anguloC = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));

        System.out.printf("Ângulo A: %.2f graus%n", anguloA);
        System.out.printf("Ângulo B: %.2f graus%n", anguloB);
        System.out.printf("Ângulo C: %.2f graus%n", anguloC);
    }
}