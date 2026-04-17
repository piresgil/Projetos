/**
 * @author Daniel Gil
 */

public class M1_UD05_Ex5_ComplexNumber {
    /**
     * Um número complexo é um número formado por um par ordenado de números
     * reais.
     * O primeiro elemento “a” define-se como parte real e o segundo “b” define-se como
     * parte imaginária. Uma forma típica de representar estes números é de forma
     * binomial como: (a + bi) onde “a” é a parte real e “b” é a parte imaginária.
     * <p>
     * Exemplos: (5 + 8i), (4,6 + 45,96i).
     * Agora, define uma classe ComplexNumber que represente um número real e que
     * implemente os métodos indicados no código a seguir.
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");
        ComplexNumber n1 = new ComplexNumber(3, 2);
        ComplexNumber n2 = new ComplexNumber(1, 4);
        // ComplexNumber n1 = new ComplexNumber(5, 8);
        // ComplexNumber n2 = new ComplexNumber(4.6, 45.96);

        System.out.println("(" + n1 + ") + (" + n2 + ")");
        System.out.println("Somar: " + ComplexNumber.somar(n1, n2) + "\n");
        System.out.println("(" + n1 + ") - (" + n2 + ")");
        System.out.println("Subtrair: " + ComplexNumber.subtrair(n1, n2));

    }
}

/**
 * Class Complex Number
 * Representa um número complexo
 */
class ComplexNumber {
    //atributos
    private double numeroReal, numeroImaginario;

    /**
     * Constructor
     * Recebe um numero complexo, que consiste em dois numeros
     *
     * @param nrReal       numero real
     * @param nrImaginario numero imaginario
     */
    public ComplexNumber(double nrReal, double nrImaginario) {
        this.numeroReal = nrReal;
        this.numeroImaginario = nrImaginario;
    }

    public double getNumeroReal() {
        return numeroReal;
    }

    public void setNumeroReal(double numeroReal) {
        this.numeroReal = numeroReal;
    }

    public double getNumeroImaginario() {
        return numeroImaginario;
    }

    public void setNumeroImaginario(double numeroImaginario) {
        this.numeroImaginario = numeroImaginario;
    }

    /**
     * Method Somar
     * Soma os números reais entre os numeros complexos, e os numeros imaginários
     * retornando un novo numero complexo
     *
     * @param c1 numero complexo
     * @param c2 numero complexo
     * @return soma de dois numeros complexos
     */
    public static ComplexNumber somar(ComplexNumber c1, ComplexNumber c2) {
        double n1 = c1.getNumeroReal() + c2.getNumeroReal();
        double n2 = (c1.getNumeroImaginario() + c2.getNumeroImaginario());
        return new ComplexNumber(n1, n2);
    }

    /**
     * Method Subtrair
     * Subtrai os números reais entre os numeros complexos, e os numeros imaginários
     * retornando un novo numero complexo
     *
     * @param c1 numero complexo
     * @param c2 numero complexo
     * @return Subtração de dois numeros complexos
     */
    public static ComplexNumber subtrair(ComplexNumber c1, ComplexNumber c2) {
        double n1 = c1.getNumeroReal() - c2.getNumeroReal();
        double n2 = c1.getNumeroImaginario() - c2.getNumeroImaginario();
        return new ComplexNumber(n1, n2);
    }

    /**
     * Method To String
     *
     * @return texto Representativo de um número complexo
     */
    @Override
    public String toString() {
        return "(" + getNumeroReal() + ") + (" + getNumeroImaginario() + "i)";
    }
}