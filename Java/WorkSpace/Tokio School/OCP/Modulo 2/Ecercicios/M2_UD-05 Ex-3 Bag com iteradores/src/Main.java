import model.Bag;
import model.Carro;

/**
 * @author Daniel Gil
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Carro car1 = new Carro("car1");
        Carro car2 = new Carro("car2");
        Carro car3 = new Carro("car3");
        Carro car4 = new Carro("car4");

        Bag<Carro> myBag = new Bag<>();

        myBag.add(car1);
        myBag.add(car2);
        myBag.add(car3);
        myBag.add(car4);
        System.out.println(myBag);
        System.out.println("Tamanho da coleção: " + myBag.size());

        System.out.println("\n*** Limpar Coleção ***");
        myBag.clear();
        System.out.println(myBag);
        System.out.println("Tamanho da coleção: " + myBag.size());
        System.out.println("Coleção Vazia: " + myBag.isEmpty());

        /////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n*** Adiciona na Coleção ***");
        myBag.add(car1);
        myBag.add(car2);
        myBag.add(car3);
        myBag.add(car4);
        System.out.println(myBag);
        System.out.println("Tamanho da coleção: " + myBag.size());

        System.out.println("Coleção contem " + car1.getName() + ": " + myBag.contains(car1));

        System.out.println("\n*** Iterator ***");
        // For Each, usando o Iterator, (não chama o metodo Iterator, pq o metodo ja é um ForEach)
        // myBag.iterator();
        for(Carro car : myBag){
            System.out.println(car);
        }
    }
}
