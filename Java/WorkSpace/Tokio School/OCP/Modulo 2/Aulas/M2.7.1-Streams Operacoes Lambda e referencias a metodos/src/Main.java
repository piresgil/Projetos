import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Streams, operações lambda e referências a métodos ***");

        System.out.println("*** List");
        List<String> numeros = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        System.out.println(numeros);

        System.out.println("\n*** Stream");
        Stream<String> streamOf = Stream.of("1", "2", "3", "4");
        streamOf.forEach(System.out::println); // imprime stream

        System.out.println("\n*** Stream com lista");
        Stream<String> streamList = numeros.stream();
        streamList.forEach(System.out::println); // imprime stream

        System.out.println("\n*** Stream com Array");
        String[] arrayNumeros = new String[]{"1", "2", "3", "4"};
        Stream<String> streamArray = Stream.of(arrayNumeros); // imprime stream
        streamArray.forEach(System.out::println); // imprime stream

        System.out.println("\n*** Stream de Animais");
        List<Animal> animais = List.of(
                new Animal("Tobias", "Cão", 3),
                new Animal("Tobias", "Cão", 3), // repetido
                new Animal("Baltazar", "Gato", 4),
                new Animal("Nina", "Cão", 3),
                new Animal("Lulu", "Peixe", 2),
                new Animal("Lili", "Gato", 2)
        );

        System.out.println("\n*** Distinct"); // Retorna a Stream eliminando elementos repetidos
        List<Animal> animaisSemRepeticoes = animais.stream()
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        System.out.println(animaisSemRepeticoes);

        System.out.println("\n*** Filter"); // (Predicate filtro): Retorna a Stream com os elementos que cumprem a condição do filtro
        List<Animal> caes = animais.stream()
                .filter(animal -> animal.getEspecie().equals("Cão"))
                .collect(Collectors.toList());
        System.out.println(caes);

        System.out.println("\n*** Filter com distinct");
        List<Animal> caes2 = animais.stream()
                .filter(animal -> animal.getEspecie().equals("Cão"))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(caes2);

        System.out.println("\n*** Skip"); // skip(long N): Remove os primeiros N elementos e retorna o restante
        List<Animal> skip = animais.stream()
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skip);

        System.out.println("\n*** skip com Limit"); // limit(long N): Retorna a Stream com os primeiros N elementos
        List<Animal> skip2 = animais.stream()
                .skip(2)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(skip2);

        System.out.println("\n*** skip com Limit e com Filter");
        List<Animal> limit = animais.stream()
                .skip(2)
                .limit(2)
                .filter(animal -> animal.getNome().equals("Nina"))
                .collect(Collectors.toList());
        System.out.println(limit);

        System.out.println("\n*** Map"); // map(Lambda mapper): Retorna a Stream com a versão mapeada de cada elemento
        // lista de Strings para capturar os nomes
        List<String> map = animais.stream()
                .map(animal -> animal.getNome())
                .collect(Collectors.toList());
        System.out.println(map);

        System.out.println("\n*** Map com Filter"); // map(Lambda mapper): Retorna a Stream com a versão mapeada de cada elemento
        // lista de Strings para capturar os nomes
        List<String> map2 = animais.stream()
                .filter(animal -> animal.getEspecie().equals("Gato"))
                .map(animal -> animal.getNome())
                .collect(Collectors.toList());
        System.out.println(map2);
    }
}