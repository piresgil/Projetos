/**
 * @author Daniel Gil
 */

import java.util.Arrays;

/**
 * Class Stack
 */
public class Stack {
    private char[] arrayChar;
    private int indicie;

    /**
     * Constructor
     *
     * @param tamanho do array
     */
    public Stack(int tamanho) {
        this.arrayChar = new char[tamanho];
        this.indicie = -1;
    }

    /**
     * Method Push
     * insere elemento no array
     *
     * @param caratere do array
     */
    public void push(char caratere) {
        arrayChar[++indicie] = caratere;
        // Incrementa o índice do topo e adiciona o valor
    }

    /**
     * Method Pop
     * elimina elemento array,limpa o valor do elemento do array, (vazio)
     *
     * @return caratere a ser eliminado
     */
    public char pop() {
        char caratere = arrayChar[indicie]; // Pega o elemento do topo
        arrayChar[indicie--] = '\0';     // Limpa o elemento no array e decrementa o topo
        return caratere;                 // Retorna o elemento removido
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(arrayChar);
    }
}
