/**
 * @author Daniel Gil
 */

public class Main2 {

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

        Stack2 pilha = new Stack2(caracteres);
        System.out.println("Pilha, por array de char");
        System.out.println(pilha);
        System.out.println("Method Pop()");
        pilha.pop();
        System.out.println(pilha);
        System.out.println("Method Push(), insere valor no array");
        pilha.push('z');
        System.out.println(pilha);
        System.out.println("Method Pop()");
        pilha.pop();
        System.out.println(pilha);
        System.out.println("Method Pop()");
        pilha.pop();
        System.out.println(pilha);
        System.out.println("Method Pop()");
        pilha.pop();
        System.out.println(pilha);
        System.out.println("Method Push(), insere valor no array");
        pilha.push('y');
        System.out.println(pilha);

        System.out.println("\nPilha por tamanho: " + tamanho);
        Stack2 pilha2 = new Stack2(tamanho);
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
        System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
        pilha2.pop();
        System.out.println(pilha2);
        System.out.println("Method Pop(), elimina ultimo valor a ser inserido no array");
        pilha2.pop();
        System.out.println(pilha2);
    }
}
