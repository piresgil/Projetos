/**
 * @author Daniel Gil
 */

public class M1_UD05_Ex3_Retangulo {
    /**
     * A proposta dessa atividade prática é criar uma classe Retângulo com as seguintes
     * características:
     * ● Incluir um construtor ao qual se passam os dados da base e altura. Se tentar dar
     * valor negativo a alguma das dimensões, corrigir o valor positivo utilizando
     * Math.abs(int a).
     * ● Um construtor sem parâmetros que inicializa um novo retângulo com base 2 e
     * altura 1.
     * ● Um método esquadria que indica se o retângulo atual é um quadrado.
     * ● Um método área que calcula a área do retângulo atual.
     * ● Um método perímetro que calcula o perímetro do retângulo atual.
     * ● Um método gira que roda o ângulo atual a 90 graus (cambia a base pela altura)
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Retangulo retangulo = new Retangulo(5, -3);
        System.out.println("Original: " + retangulo.toString());

        System.out.println("Quadrado: " + Retangulo.esquadria(retangulo));
        System.out.println("Área: " + Retangulo.area(retangulo));
        System.out.println("Perímetro: " + Retangulo.perimetro(retangulo));
        System.out.println("Retângulo actual Girar 90º: " + Retangulo.girar(retangulo));
    }
}

class Retangulo {
    private double base;
    private double altura;

    /**
     * Constructor com dois @param
     * se algum dos @param forem negativos aplica o method
     * "Math.abs()", converte o número para sua versão positiva.
     *
     * @param base   indica a base do retângulo
     * @param altura indica a altura do retângulo
     */
    public Retangulo(double base, double altura) {
        if (base < 0) {
            base = Math.abs(base);
        }
        if (altura < 0) {
            altura = Math.abs(altura);
        }

        this.base = base;
        this.altura = altura;
    }

    /**
     * Constructor "Padrão"
     * Sem @param, instancia um retângulo de base 2 e altura 1
     */
    public Retangulo() {
        this.base = 2;
        this.altura = 1;
    }

    /**
     * Method Esquadria
     * Se a base for igual há altura então é um quadrado
     *
     * @param retangulo a ser comparado como um quadrado
     * @return verdadeiro se for quadrado e falso se for um retângulo
     */
    static boolean esquadria(Retangulo retangulo) {
        if (retangulo.base == retangulo.altura) {
            return true;
        }
        return false;
    }

    /**
     * Method Área
     * Base x Altura
     *
     * @return area
     */
    static double area(Retangulo retangulo) {
        return retangulo.base * retangulo.altura;
    }

    /**
     * Method Perímetro
     * Soma de todos os lados
     *
     * @return perímetro
     */
    static double perimetro(Retangulo retangulo) {
        return 2 * (retangulo.base + retangulo.altura);
    }

    /**
     * Method Girar
     * Girar 90º (cambia a base pela altura)
     *
     * @return novo retângulo girado aos 90º
     */
    static Retangulo girar(Retangulo retangulo) {
        Retangulo retangulo90 = new Retangulo();
        retangulo90.base = retangulo.altura;
        retangulo90.altura = retangulo.base;
        return retangulo90;
    }

    /**
     * Method toString
     *
     * @return texto representativo de um retângulo
     */
    @Override
    public String toString() {
        return "Retângulo: " +
                "(base: " + base +
                ", altura: " + altura + ")";
    }
}
