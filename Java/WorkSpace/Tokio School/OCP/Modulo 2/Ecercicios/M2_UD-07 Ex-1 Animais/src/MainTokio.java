import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author Daniel Gil
 */
public class MainTokio {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        // Lista de animais
        List<Animal> listAnimais = getAnimals();
        System.out.println(listAnimais);

        /* Eliminar todos animais perigosos
         * Predicate
         */
        System.out.println("\nEliminar todos animais perigosos:");
        Predicate<Animal> animalPerigoso = Animal::isPerigoso;
        listAnimais.removeIf(animalPerigoso);
        System.out.println(listAnimais);


        /* Listar os nomes de todos os animais
         * Consumer
         */
        System.out.println("\nListar os nomes de todos os animais:");
        Consumer<Animal> animalGetName = (name) -> System.out.println(name.getNome());
        listAnimais.forEach(animalGetName);


        /* Colocar 10kg de comida a cada animal
         * Consumer
         */
        System.out.println("\nColocar 10kg de comida a cada animal:");
        Consumer<Animal> animalAlimentar = (alimentarAnimal) -> alimentarAnimal.alimentar(10);
        listAnimais.forEach(animalAlimentar);
        System.out.println(listAnimais);

        /* Eliminar todos animais que pesem menos de 10 kilos
         * Predicate
         */
        Predicate<Animal> menosDezKilos = (dezKilos) -> dezKilos.getPeso() < 10;
        listAnimais.removeIf(menosDezKilos);
        System.out.println("\nEliminar todos animais que pesem menos de 10 kilos:");
        System.out.println(listAnimais);

    }

    /**
     * Method Auxiliar
     *
     * @return lista de animais
     */
    private static List<Animal> getAnimals() {
        Animal cao = new Animal("cao", "cao", "cao", 10.0, 22.0, false, "cao", 0);
        Animal gato = new Animal("gato", "gato", "gato", 4.0, 1.0, false, "gato", 0);
        Animal coelho = new Animal("coelho", "coelho", "coelho", 3.0, 1.0, false, "coelho", 0);
        Animal papagaio = new Animal("papagaio", "papagaio", "papagaio", 1.0, 20.0, false, "papagaio", 0);
        Animal serpente = new Animal("serpente", "serpente", "serpente", 2.0, 20.0, true, "serpente", 0);
        Animal tigre = new Animal("tigre", "tigre", "tigre", 50.0, 2.0, true, "tigre", 0);

        List<Animal> listAnimais = new ArrayList<>();
        listAnimais.add(cao);
        listAnimais.add(gato);
        listAnimais.add(coelho);
        listAnimais.add(papagaio);
        listAnimais.add(serpente);
        listAnimais.add(tigre);
        return listAnimais;
    }
}