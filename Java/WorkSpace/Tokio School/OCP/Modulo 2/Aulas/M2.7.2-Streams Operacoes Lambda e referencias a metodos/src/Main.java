import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Streams, operações lambda e referências a métodos ***");

        // Streams
        // API para ajudar a manipular coleções

        // Acessar os streams
        // Collections<Pessoa> collectionsPessoa= new ArraysList<>();
        List<Pessoa> pessoaList = new ArrayList<>();
        Set<Pessoa> pessoaSet = new HashSet<>();
        Map<Integer, Pessoa> pessoaMap = new HashMap<>();

        Pessoa daniel = new Pessoa("Daniel", 37);
        Pessoa elisa = new Pessoa("Elisa", 3);
        Pessoa francisca = new Pessoa("Francisca", 4);
        Pessoa bernardo = new Pessoa("Bernardo", 18);
        Pessoa eduardo = new Pessoa("Eduardo", 18);

        List<Pessoa> listaPessoas = List.of(daniel, elisa, francisca, bernardo, eduardo);


        // Methods intermediários

        /*
         * listaPessoas.stream().filter(pessoa -> {
         *     System.out.println("Filtrando..."); // executa todas as vezes, mesmo nao havendo correspondencia
         *     return pessoa.getIdade() >= 18;
         * }).forEach(pessoa -> System.out.println(pessoa));
         */

        System.out.println("\n*** filter; map;");
        listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .map(pessoa -> pessoa.getNome())
                .forEach(p -> System.out.println(p));

        System.out.println("\n*** soma");
        Double sum = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .mapToDouble(pessoa -> pessoa.getIdade())
                .sum(); // 55
        System.out.println(sum);

        System.out.println("\n*** distinct");
        listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .mapToDouble(pessoa -> pessoa.getIdade())
                .distinct()
                .forEach(p -> System.out.println(p));

        System.out.println("\n*** sorted por alfabetico");
        listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .map(pessoa -> pessoa.getNome())
                .sorted() // ordem alfabetica
                .forEach(p -> System.out.println(p));

        System.out.println("\n*** sorted por idade");
        listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .sorted((p1, p2) -> {
                    return p1.getIdade() > p2.getIdade() ? 0 : 1;
                })
                .forEach(p -> System.out.println(p));


        System.out.println("\n*** Parallel com filter"); // usa toda a CPU disponivel, cria novas threads por baixo dos panos
        /**
         * Quando usar parallel()?
         *
         * Grandes conjuntos de dados: Para obter um benefício real, é ideal utilizar streams paralelos em conjuntos de dados consideravelmente grandes.
         * Operações independentes: As operações realizadas nos elementos do stream devem ser independentes umas das outras, ou seja, a ordem de execução não deve afetar o resultado final.
         * Custo de paralelismo: É importante considerar o custo de criar e gerenciar múltiplas threads. Em operações simples ou em conjuntos de dados pequenos, o overhead do paralelismo pode superar os benefícios.
         */
        listaPessoas.stream()
                .parallel()
                .filter(pessoa -> pessoa.getIdade() >= 18)
                .forEach(p -> System.out.println(p));

        // Criando um array com o Stream
        System.out.println("\ncria array com stream");
        //IntStream rage = IntStream.range(0, 10); // array de 0 a 9
        IntStream rage = IntStream.rangeClosed(0, 10); // array de 0 a 10
        //rage.forEach(number -> System.out.println(number));
        rage.forEach(System.out::println); // Referências a métodos - Métodos estáticos

        System.out.println("\nReferencia a metodos (::)");
        listaPessoas.forEach(daniel::imprimirPessoa);


        System.out.println("\n*** Peek e count");
        // peek(Consumer ação): Retorna a Stream após executar a ação que é passada como parâmetro (existe por motivos de debugging,
        // para poder ver como os elementos estão dispostos no Stream num determinado momento)
        long count = listaPessoas.stream()
                .peek(System.out::println)
                .filter(pessoa -> pessoa.getIdade() > 18)
                .count();
        System.out.println(count);


        // question OCP
        "abracadabra".chars()
                .distinct()
                .peek(ch -> System.out.printf("%c", ch))
                .sorted();

        // Methods terminais
        pessoaList.stream();
        pessoaSet.stream();
        pessoaMap.entrySet().stream();
    }
}