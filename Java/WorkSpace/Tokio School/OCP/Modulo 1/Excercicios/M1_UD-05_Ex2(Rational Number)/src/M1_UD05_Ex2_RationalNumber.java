/**
 * @author Daniel Gil
 */

public class M1_UD05_Ex2_RationalNumber {

    /**
     * Method Main
     */
    public static void main(String[] args) {

        Rational nr1 = new Rational(1, 2); // Representa 1/2
        Rational nr2 = new Rational(3, 4); // Representa 3/4

        System.out.println("Soma: " + nr1.soma(nr2)); // 5/4
        System.out.println("Subtração: " + nr1.subtracao(nr2)); // 1/-4
        System.out.println("Multiplicação: " + nr1.multiplicacao(nr2)); // 1/2
        System.out.println("Divisão: " + nr1.divisao(nr2)); // 1/3
    }

    /**
     * Soma: a/b + c/d = (ad + bc)/bd
     * Subtração: a/b - c/d = (ad-bc)/bd
     * Multiplicação: a/b * c/d = ac/bd
     * Divisão: (a/b)/(c/d) = ad/bc
     * <p>
     * Class recebe dois números que representam uma fração, um numerador e um denominador,
     * através dos seus methods (soma, subtração...) recebe outra fração e realiza a operação entre as duas frações.
     */
    public static class Rational {

        private int numerador;
        private int denominador;

        // Construtor que recebe o numerador e o denominador,
        // e simplifica a fração
        public Rational(int numerador, int denominador) {
            if (denominador == 0) {
                System.out.println("Denominador não pode ser zero");
            }
            this.numerador = numerador;
            this.denominador = denominador;

            // simplifica fração
            simplificar();
        }

        public int getNumerador() {
            return numerador;
        }

        public void setNumerador(int numerador) {
            this.numerador = numerador;
        }

        public int getDenominador() {
            return denominador;
        }

        public void setDenominador(int denominador) {
            this.denominador = denominador;
        }

        /**
         * Method Simplificar Fração,
         * Este method faz a simplificação dos cálculos, dos Divisores Máximos Comuns,
         * Atribui ao numerador a divisão do maior divisor comum, assim como ao denominador,
         * com estes dois methods combinados obtemos uma simplificação cara calculo de frações.
         */
        private void simplificar() {
            int resultado = maxDivisor(getNumerador(), getDenominador());
            setNumerador(getNumerador() / resultado);
            setDenominador(getDenominador() / resultado);
        }

        /**
         * Method Máximo Divisor Comum,
         * Este method é necessário para simplificação das frações,
         * O Máximo Divisor Comum de dois ou mais números, é o maior número que pode dividir por todos eles sem deixar resto.
         * Em outras palavras, é o maior divisor que esses números têm em comum.
         *
         * @param a numerador, de uma fração
         * @param b denominador, de uma fração
         * @return Máximo Divisor Comum
         */
        private int maxDivisor(int a, int b) {
            if (b == 0)
                return a;
            return maxDivisor(b, a % b);
        }

        /**
         * Method Soma
         * Representa a soma de duas frações
         * Soma: a/b + c/d = (ad + bc)/bd
         *
         * @param outro Representa a fração a ser adicionada (somada), (pela fração this.class).
         */
        public Rational soma(Rational outro) {
            int novoNumerador = getNumerador() * outro.getDenominador() + outro.getNumerador() * getDenominador();
            int novoDenominador = getDenominador() * outro.getDenominador();
            return new Rational(novoNumerador, novoDenominador);
        }

        /**
         * Method Subtração
         * Representa a subtração de duas frações
         * Subtração: a/b - c/d = (ad-bc)/bd
         *
         * @param outro Representa a fração a ser subtraída, (pela fração this.class).
         */
        public Rational subtracao(Rational outro) {
            int novoNumerador = getNumerador() * outro.getDenominador() - outro.getNumerador() * getDenominador();
            int novoDenominator = getDenominador() * outro.getDenominador();
            return new Rational(novoNumerador, novoDenominator);
        }

        /**
         * Method Multiplicação
         * Representa a Multiplicação de duas frações
         * Multiplicação: a/b * c/d = ac/bd
         *
         * @param outro Representa a fração a ser multiplicada, (pela fração this.class).
         */
        public Rational multiplicacao(Rational outro) {

            try {
                int novoNumerador = getNumerador() * outro.getNumerador() / getDenominador() * outro.getDenominador();
                int novoDenominator = getDenominador() * outro.getDenominador();
                return new Rational(novoNumerador, novoDenominator);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            return outro;
        }

        /**
         * Method Divisão
         * Representa a Divisão de duas frações
         * Divisão: (a/b)/(c/d) = ad/bc
         *
         * @param outro Representa a fração a ser dividida, (pela fração this.class).
         */
        public Rational divisao(Rational outro) {
            //Condição de divisão
            if (outro.getNumerador() == 0) {
                System.out.println("Divisão por zero não permitida.");
            }
            int novoNumerador = getNumerador() * outro.getDenominador() / outro.getNumerador() * getDenominador();
            int novoDenominator = getDenominador() * outro.getNumerador();
            return new Rational(novoNumerador, novoDenominator);
        }

        /**
         * Method ToString,
         *
         * @return Texto representativo de uma fração
         */
        @Override
        public String toString() {
            return getNumerador() + "/" + getDenominador();
        }
    }
}