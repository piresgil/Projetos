import model.stack.Stack;
import model.stack.internal.GenericStack;

/**
 * @author Daniel Gil
 */

public class Main {

    /**
     * Atributos estáticos da Class
     */
    private static final int tamanho = 5;

    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");
        System.out.println("*** Pilha de vogais ***");

        System.out.println("\nPilha por tamanho: " + tamanho);
        Stack<Character> pilha = new GenericStack<>(tamanho);

        // pilha.pop();

        System.out.println(pilha);
        System.out.println("Method Push()");
        pilha.push('a');
        System.out.println(pilha);
        System.out.println("Method Push()");
        pilha.push('b');
        System.out.println(pilha);
        System.out.println("Method Push()");
        pilha.push('c');
        System.out.println(pilha);
        System.out.println("Method Push()");
        pilha.push('d');
        System.out.println(pilha);
        System.out.println("Method Push()");
        pilha.push('e');
        System.out.println(pilha);

        //pilha.push('f');

        System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
        pilha.pop();
        System.out.println(pilha);
        System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
        pilha.pop();
        System.out.println(pilha);
    }
}
