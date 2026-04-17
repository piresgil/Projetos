import java.util.ArrayList;
import java.util.LinkedList;

public class ListExemple {
    public static void main(String[] args) {
        System.out.println("*** Coleções e Genéricos ***");

        // Array simples, Sem Coleção
        System.out.println("*** Array simples, sem Coleção");
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        for (int number : numbers) {
            System.out.print("[" + number + "]");
        }

        // ArrayList
        System.out.println("\n\n*** List, ArrayList");
        java.util.List<Integer> numbersList = new ArrayList<>();
        long startAdd = System.nanoTime();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        long endAdd = System.nanoTime();
        System.out.println("Numbers: " + numbersList + " ,Nano time: " + (endAdd - startAdd));
        // numbersList.add(4);
        //System.out.println("Numbers: " + numbersList);

        long startAddIndex = System.nanoTime();
        numbersList.add(2, 5);
        long endAddIndex = System.nanoTime();
        System.out.println("Numbers: " + numbersList + " ,Nano time: " + (endAddIndex - startAddIndex));

        long startAddgET = System.nanoTime();
        numbersList.get(2);
        long endAddgET = System.nanoTime();
        System.out.println("Numbers, GET: " + numbersList.get(2) + " ,Nano time: " + (endAddgET - startAddgET));


        // LinkedList
        System.out.println("\n*** List, LinkedList");
        java.util.List<Integer> numbersListLinked = new LinkedList<>();
        // add mais LENTO que arraylist
        // add Index mais LENTO que arraylist
        // get mais RÁPIDO que arraylist

        long startAddLinkedList = System.nanoTime();
        numbersListLinked.add(1);
        numbersListLinked.add(2);
        numbersListLinked.add(3);
        long endAddLinkedList = System.nanoTime();
        System.out.println("Numbers: " + numbersListLinked + " ,Nano time: " + (endAddLinkedList - startAddLinkedList));

        long startAddIndexLinkedList = System.nanoTime();
        numbersListLinked.add(2, 5);
        long endAddIndexLinkedList = System.nanoTime();
        System.out.println("Numbers: " + numbersListLinked + " ,Nano time: " + (endAddIndexLinkedList - startAddIndexLinkedList));

        long startAddgETLinkedList = System.nanoTime();
        numbersListLinked.get(2);
        long endAddgETLinkedList = System.nanoTime();
        System.out.println("Numbers, GET: " + numbersListLinked.get(2) + " ,Nano time: " + (endAddgETLinkedList - startAddgETLinkedList));

    }
}