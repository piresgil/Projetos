import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Gil
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        // Lista de animais
        List<Animal> listAnimais = getAnimals();

        // listar nomes dos animais com forEach
        listAnimais.forEach(animal -> System.out.println(animal.getNome()));
        System.out.println();

        // Method Marcar como perigoso com filter e forEach
        /**
         * listAnimais.stream()
         * .filter(animal -> animal.getNome().equals("papagaio"))
         * .forEach(animal -> animal.marcarComoPerigoso());
         **/
        listAnimais.stream()
                .filter(animal -> animal.getNome().equals("papagaio"))
                .forEach(Animal::marcarComoPerigoso);

        // Metodo alimentar com filter e forEach
        listAnimais.stream()
                .filter(animal -> animal.getPeso() < 4)
                .forEach(animal -> animal.alimentar(2));


        // Remove animal perigoso com RemoveIf
        // listAnimais.removeIf(animal -> animal.isPerigoso());
        listAnimais.removeIf(Animal::isPerigoso);

        // colocar 10KG comida com forEach
        listAnimais.forEach(animal -> animal.alimentar(animal.getQuantidadeComida() + 10));

        // elimina todos animais com mais de 10kg com RemoveIf
        listAnimais.removeIf(animal -> animal.getPeso() > 10);

        // listagem final
        listAnimais.forEach(System.out::println);
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