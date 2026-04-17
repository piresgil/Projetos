/**
 * @author Daniel Gil
 */

public class M1_UD04_Ex1 {

    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");

        int soma1 = sumvarargs(5, 5);
        int soma2 = sumvarargs(10, 10);
        int soma3 = sumvarargs(10, 10, 10);
        int soma4 = sumvarargs(10, 10, 10, 10);
        int soma5 = sumvarargs(10, 10, 10, 10, 10);

        System.out.println("Soma 1: " + soma1); // 10
        System.out.println("Soma 2: " + soma2); // 20
        System.out.println("Soma 3: " + soma3); // 30
        System.out.println("Soma 4: " + soma4); // 40
        System.out.println("Soma 5: " + soma5); // 50

    }

    /**
     * Method Soma vararg
     *
     * @param intArrays array de inteiros, que será percorrido
     *                  e atribuído a soma de todos os seus valores
     * @return a soma de todos os valores do array
     */
    static int sumvarargs(int... intArrays) {
        int soma = 0;
        for (int numero : intArrays) {
            soma += numero;
        }
        return soma;
    }
}