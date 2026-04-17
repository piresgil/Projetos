import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Expressões lambda pré-definidasReunião ***");

        System.out.println("*** Consumer");
        // Consumer -> quando precisa realizar ação em um obj mas não necessita de retornar nenhum valor
        Consumer<Integer> imprimirNumero = (numero) -> System.out.println("Imprimindo o numero: " + numero);
        imprimirNumero.accept(10);
        imprimirNumero.accept(20);
        imprimirNumero.accept(100);

        System.out.println("\n*** Supplier");
        // Supplier -> quando precisa retornar um valor sem receber parâmetro
        Supplier<Double> obterNumeroAleatorio = () -> {
            Random random = new Random();
            return random.nextDouble();
        };
        System.out.println(obterNumeroAleatorio.get());
        System.out.println(obterNumeroAleatorio.get());
        System.out.println(obterNumeroAleatorio.get());

        System.out.println("\n*** Function");
        // Function -> quando precisa transformar um tipo de dado noutro tipo
        Function<String, Double> toDouble = (str) -> (Double.valueOf(str));
        System.out.println(toDouble.apply("10"));
        System.out.println(toDouble.apply("0.65"));
        // System.out.println(toDouble.apply("aa")); // exception

        System.out.println("\n*** Predicate");
        // Predicate -> quando precisa testar alguma condição
        Predicate<Integer> maiorDeIdade = (idade) -> idade >= 18;
        System.out.println("Maior de idade? " + maiorDeIdade.test(9));
        System.out.println("Maior de idade? " + maiorDeIdade.test(18));
        System.out.println("Maior de idade? " + maiorDeIdade.test(20));


    }
}