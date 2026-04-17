import java.util.ArrayList;

public class M1_UD03_Ex6 {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        int numero = 6;

        ListaCollatz.collatz(numero);
    }
}
/**
 * Class ListCollatz
 */
class ListaCollatz {

    /**
     * Devolver a lista de Collatz para o valor n
     *
     * @param n valor inteiro positivo (>0)
     * @return Array de inteiros representando a lista de Collatz,
     * os valores restantes do array iniciam-se a zero
     * <p>
     * Dado um número devolver um array com a série de números de Collatz inicial.
     * Para não ter de trabalhar com um array de tamanho variável supor que o array tenha um tamanho fixo
     * suficiente (p.ex. 300 elementos) para acomodar a série que os elementos não utilizados se fixem a zero.
     * <p>
     * Por exemplo, para o número 6 iria devolver o seguinte array:
     * [6, 3, 10, 5, 16, 8, 4, 2, 1, 0, 0, 0, 0, ..., 0]
     * <p>
     * Foi uma abordagem interessante, mas tem alguns problemas.
     * <p>
     * Independentemente de a função receber um 1, ou um Integer.MAX_VALUE,
     * estarás sempre a ser criado um array de 300 posições sem necessidade.
     * Será que 300 é um número muito grande? Ou será que dá para todos os casos?
     * Não existe bem uma forma de determinamos qual será o tamanho correto do array.
     * <p>
     * Até à data, há uma condição que sabemos que é verdadeira,
     * será que conseguiríamos pensar numa forma diferente de resolver o problema,
     * e não termos de assumir o tamanho de um array?
     */
    static int[] collatz(int n) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(n);
        // Sequencia que Calcula a sequência de Collatz
        // Sequencia Collatz termina sempre em 1
        while (n > 1) {
            if (n % 2 == 0) {// par
                n = n / 2;
            } else { //impar
                n = n * 3 + 1;
            }
            listaNumeros.add(n);
        }
        // Array a ser retornado recebe um novo array com o tamanho da lista
        // percorre a lista, e atribui valores no array
        int[] resultado = new int[listaNumeros.size()];
        for (int i = 0; i < listaNumeros.size(); i++) {
            if (listaNumeros.get(i) > 0) {
                resultado[i] = listaNumeros.get(i);
            }
            // Imprime array
            System.out.println(resultado[i]);
        }
        return resultado;
    }
}
