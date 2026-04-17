/**
 * @author Daniel Gil
 */

public class M1_UD06_Ex1_Circle {
    /**
     * Nessa atividade prática, deverás criar uma subclasse de TwoDShape com o nome
     * Circle.
     * <p>
     * Deverás incluir um método area() que calcule a área de um círculo e um
     * construtor que utilize super para inicializar a parte TwoDShape.
     * <p>
     * Poderás seguir esses passos para a realização da atividade:
     * Classe TwoDShape:
     * - Cria uma classe TwoDShape com dois atributos (base, altura);
     * <p>
     * Classe Circle:
     * - Cria uma classe Circle que estende do TwoDShape (em que vai ter como
     * atributo “r” e uma constante “Pi”)
     * <p>
     * - Cria um método area() no Circle que calcule a área do círculo.
     * - Cria um construtor do circle usando o super()
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");

        System.out.println("Circle area: " + Circle.area(5));

    }

    /**
     * Class Two D Shape
     */
    class TwoDShape {
        private double base, altura;

        public TwoDShape(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }
    }

    /**
     * Class Circle
     * Extends de Tow Shape
     */
    class Circle extends TwoDShape {
        private static double r;
        private static final double PI = Math.PI;

        /**
         * Constructor
         * usa constructor do super, que recebe um @param
         *
         * @param raio recebe apenas o raio,
         *             PI é uma constante
         */
        public Circle(double raio) {
            super(PI, raio);
            this.r = raio;
        }

        /**
         * Method Area
         * Calcula a Area de um circulo
         *
         * @param raio de um circulo
         * @return area de um círculo
         */
        static double area(double raio) {
            return PI * Math.pow(raio, 2);
        }
    }
}