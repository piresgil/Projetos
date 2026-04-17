import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Daniel Gil
 */

public class M1_UD05_Ex4_Bag {
    /**
     * Nessa atividade prática, deverás criar uma classe Bag que nos permita armazenar
     * uma coleção desordenada de objetos, na qual ao extraí-los, todos tenham a mesma
     * probabilidade de serem escolhidos.
     * No código abaixo estão os métodos a criar e uma explicação de como devem
     * funcionar
     */
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");
        Bag myBag = new Bag();

        //PutInBag(String items) deve aceitar e guardar uma coleção de Objects
        myBag.PutInBag(getItems());
        System.out.println(myBag.toString());

        //TakeFromBag() deve remover e retornar um elemento aleatório da Bag
        System.out.println("String sorteada: " + myBag.TakeFromBag());
        System.out.println(myBag.toString());
        //////////////////////////////////////////////////////////////////
        System.out.println("String sorteada: " + myBag.TakeFromBag());
        System.out.println(myBag.toString());
        //////////////////////////////////////////////////////////////////
        System.out.println("String sorteada: " + myBag.TakeFromBag());
        System.out.println(myBag.toString());
        //////////////////////////////////////////////////////////////////
        System.out.println("String sorteada: " + myBag.TakeFromBag());
        System.out.println(myBag.toString());
    }

    private static List<String> getItems() {
        return List.of(
                "Pen",
                "Book",
                "Laptop",
                "Powerbank",
                "Keys"
        );
    }
}

/**
 * Class Bag
 */
class Bag {
    private List<String> bag;

    /**
     * Constructor "Padrão",
     * sem @param
     */
    public Bag() {
        this.bag = new ArrayList<>();
    }

    /**
     * Method Put in Bag,
     * Adiciona uma lista de Strings, e imprime
     *
     * @param lista lista de strings
     */
    void PutInBag(List<String> lista) {
        if (bag.isEmpty()) {
            this.bag = lista;
        }
    }


    /**
     * Method Take from Bag,
     * Retira da lista uma "String" aleatória,
     * com a ajuda da class Random, para sortear uma "String" da lista pelo indice
     *
     * @return string sorteada, com o method .random()
     */
    String TakeFromBag() {
        if (bag.isEmpty()) {
            return "The bag is empty!";
        }
        bag = new ArrayList<>(bag);
        Random sortear = new Random();
        int indice = sortear.nextInt(bag.size());
        String stringSorteada = bag.get(indice);
        bag.remove(bag.get(indice));
        return stringSorteada;
    }

    /**
     * Method To String
     *
     * @return texto representativo de uma Bag (lista de "Strings")
     */
    @Override
    public String toString() {
        return "Minha Lista: " + bag;
    }
}