import exceptions.StackEmptyException;
import exceptions.StackFullException;

/**
 * @author Daniel Gil
 */

public class Main {

    /**
     * Atributos estáticos da Class
     */
    private static final char[] caracteres = {'a', 'e', 'i', 'o', 'u'};
    private static final int tamanho = 5;

    /**
     * Method Main
     */
    public static void main(String[] args) {

        System.out.println("*** Bem Vindo ***");
        System.out.println("*** Pilha de vogais ***");

        System.out.println("\nPilha por tamanho: " + tamanho);
        Stack pilha2 = new Stack(tamanho);

        try {
           // pilha2.pop(); // EXCEPTION

            System.out.println(pilha2);
            System.out.println("Method Push()");
            pilha2.push('a');
            System.out.println(pilha2);
            System.out.println("Method Push()");
            pilha2.push('b');
            System.out.println(pilha2);
            System.out.println("Method Push()");
            pilha2.push('c');
            System.out.println(pilha2);
            System.out.println("Method Push()");
            pilha2.push('d');
            System.out.println(pilha2);
            System.out.println("Method Push()");
            pilha2.push('e');
            System.out.println(pilha2);

            pilha2.push('f'); // EXCEPTION

            System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
            pilha2.pop();
            System.out.println(pilha2);
            System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
            pilha2.pop();
            System.out.println(pilha2);

        } catch (StackFullException | StackEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
