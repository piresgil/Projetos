/**
 * @author Daniel Gil
 */
public class M1_UD04_Ex3 {
    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");

        // Array para Média
        double[] array = {10.5, 9.5, 10.0};

        //Matriz para Média
        double[][] matriz = {
                {10.5, 9.5, 10.0},
                {20.5, 19.5, 20.0},
                {30.5, 29.5, 30.0}
        };

        // Array para função minMax
        int[] arrayInt = {15, 10};

        // Média array
        System.out.println("\n*** Média Array ***");
        System.out.println("\nMedia: " + Matrizes.mediaArray(array));
        //media Matriz
        System.out.println("\n*** Média Matriz ***");
        System.out.println("\nMedia: " + Matrizes.mediaMatiz(matriz));
        System.out.println();
        // Minimo e Maximo
        System.out.println("*** minMax ***");
        System.out.print("Array original: ");
        Matrizes.imprimirArray(arrayInt);
        System.out.print("\nFunção minMax: ");
        arrayInt = Matrizes.minMax(arrayInt);
        Matrizes.imprimirArray(arrayInt);
    }
}
/*
 * Só a nota que, por norma, os System.out.println devem ficar fora da função.
 * Ou seja, a função deve apenas fazer aquilo que o seu nome sugere, "mediaMatriz".
 * A parte de imprimir no ecrã deve ser responsabilidade, neste caso, do Main.
 */

/**
 * Class Matrizes
 * Responsavel por fazer calculos de arrays e matrizes
 */
class Matrizes {

    /**
     * Method Media Array
     * Percorre o array atribuindo a soma, para no final, fazer a divisão, e encontrar a média
     *
     * @param numeros vector de numeros que serão somados,
     *                e no final divididos para se entrontrar a media de todo o array
     * @return a média de todo o array
     */
    static double mediaArray(double[] numeros) {
        double soma = 0.0;
        // Exibindo a matriz
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
            soma += numeros[i];
        }
        return soma / numeros.length;
    }

    /**
     * Method Media Matriz
     * Percorre a matriz atribuindo a soma, para no final, fazer a divisão, e encontrar a média
     *
     * @param numeros vector de vector [][], que contem os numeros que serão somados
     *                e no final divididos para se encontrar a média da matriz
     * @return a média de toda a matriz
     */
    static double mediaMatiz(double[][] numeros) {
        double soma = 0.0;
        // Exibindo a matriz
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print(numeros[i][j] + " ");
                soma += numeros[i][j];
            }
        }
        return soma / numeros.length;
    }

    /**
     * Method Minimo e Maximo
     * Dentro de um array, vai procurar qual o valor máximo e o valor minimo
     *
     * @param numeros aray de numeros que serão analizados
     * @return novo aray ordenado, onde oprimeiro valor será o mínimo
     * e o segundo valor será o máximo. A função minMax
     */
    static int[] minMax(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            System.out.println("O array não pode estar vazio!");
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int nr : numeros) {
            if (nr < min) {
                min = nr;
            }
            if (nr > max) {
                max = nr;
            }
        }
        return new int[]{min, max};
    }

    /**
     * Metod Imprimir Array
     * Imprime no console os numeros do array
     *
     * @param numeros array de numeros a serem mostrados
     * @return array de numeros inteiros
     */
    static int[] imprimirArray(int[] numeros) {
        for (int nr : numeros) {
            System.out.print(nr + " ");
        }
        return numeros;
    }
}