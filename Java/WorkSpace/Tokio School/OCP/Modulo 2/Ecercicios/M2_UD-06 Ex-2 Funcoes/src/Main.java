/**
 * @author Daniel gil
 */

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        Dog dog = new Dog("Bobby", 50, 2);
        Dog dog2 = new Dog("Tareco", 30, 1);

        // getName
        Function<Dog, String> getName = (cao) -> cao.getName();
        String dogName = getName.apply(dog);
        System.out.println("Dog name: " + dogName);

        /////////////////////////////////////////////
        // getInitial
        String TextoExemplo = "Daniel";
        Function<String, Character> getInitial = (texto) -> texto.charAt(0);
        char letra = getInitial.apply(TextoExemplo);
        System.out.println("primeira letra de " + TextoExemplo + " é: " + letra);

        //////////////////////////////////////////////
        // andThen
        Function<Dog, Character> primeiraLetra = getName.andThen(getInitial);
        letra = primeiraLetra.apply(dog2); // dog2 Tareco
        System.out.println("Method andThen: " + letra);

        //////////////////////////////////////////////
        // Compose
        Function<Dog, Character> priLetra = getInitial.compose(getName);
        letra = String.valueOf(priLetra.apply(dog)).charAt(0); // dog Bobby
        System.out.println("Method compose: " + letra);

    }
}