import java.util.*;
import java.util.List;

public class SetExemple {
    public static void main(String[] args) {
        System.out.println("*** Set - HashSet");

        // Set - Conjunto de dados , variaveis; Set é interface, e quem implementa a interface são:
        // HashSet, TreeSet
        // não existem duplicações no SET, tanto no HashSet como no TreeSet

        // HasHSET não considera ordem de inserção - HashTable(implementação)
        /*
         * Set<String> nomes = new HashSet();
         *
         * nomes.add("Daniel"); // 2º elemento da coleção
         * nomes.add("Elisa"); // 3º elemento da coleção
         * nomes.add("Francisca"); // 1º elemento da coleção
         * System.out.println(nomes);
         * nomes.remove("Francisca");
         * System.out.println(nomes);
         * System.out.println(nomes.size());
         * System.out.println("contains: " + nomes.contains("Daniel"));
         * nomes.add("Daniel"); // não vai inserir na coleção, SET não deixa repetições
         * System.out.println(nomes);
         */

        List<String> nomesList = Arrays.asList("Daniel", "Elisa", "Francisca", "Daniel", "Elisa", "Francisca");
        // nomes.addAll(nomesList);
        Set<String> nomes = new HashSet(nomesList); // remove os duplicados
        System.out.println(nomes);

        System.out.println("\n*** Set - TreeSet");
        // muito mais lento que o HashSet
        // TreeSet ordena a coleção

        Set<String> nomesTreeSet = new TreeSet<>();
        nomesTreeSet.add("Daniel");
        nomesTreeSet.add("Elisa");
        nomesTreeSet.add("Francisca");
        System.out.println(nomesTreeSet);
    }
}
