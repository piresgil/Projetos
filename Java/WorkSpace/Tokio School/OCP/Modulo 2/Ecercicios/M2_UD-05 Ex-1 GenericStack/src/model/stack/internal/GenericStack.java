/**
 * @author Daniel Gil
 */
package model.stack.internal;
import model.stack.Stack;
import java.util.Arrays;

/**
 * Class GenericStack
 */
public class GenericStack<T> implements Stack<T> {
    private T[] array;
    private int indicie;

    /**
     * Constructor
     *
     * @param tamanho do array
     */
    public GenericStack(int tamanho) {
        this.array = (T[]) new Object[tamanho]; // Criação genérica, com Cast de <T>
        this.indicie = -1;
    }

    /**
     * Method Push
     * insere elemento no array
     *
     * @param elemento do array
     */
    public void push(T elemento) {
        if (indicie == array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("A pilha está cheia!");
        }
        array[++indicie] = elemento; // Incrementa o índice do topo e adiciona o valor
    }

    /**
     * Method Pop
     * elimina elemento array,limpa o valor do elemento do array, (vazio)
     *
     * @return elemento a ser eliminado
     */
    public T pop() {
        if (indicie == -1) {
            throw new IllegalStateException("A pilha está vazia!");
        }
        T elemento = array[indicie]; // Pega o elemento do topo
        array[indicie--] = null;     // Limpa o elemento no array e decrementa o topo
        return elemento;             // Retorna o elemento removido
    }

    @Override
    public String toString() {
        return "GenericStack: " + Arrays.toString(array);
    }
}
