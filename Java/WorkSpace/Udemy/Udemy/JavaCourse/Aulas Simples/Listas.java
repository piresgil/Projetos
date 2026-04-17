/*
* @ Daniel Gil 
*/

package application;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Listas {
    /*
     * tipo list é uma INTERFACE,
     * precisa de uma class implementa essa INTERFACE
     */
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();// instaciação

        // operações
        list.add("Maria");
        list.add("Alex");
        list.add("Bob");
        list.add("Ana");

        // percorrendo a lista
        // FOR EACH
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }

        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());
        list.add(2, "Marco");// inserir um elemento numa posição
        System.out.println("----inserir um elemento numa posição(2)-----");
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }
        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());
        System.out.println("----update lista----");

        // FOR EACH percorrendo a lista para UPDATE
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }
        System.out.println("----Remover da lista ('Ana')----");
        list.remove(1);
        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());
        System.out.println("----update lista----");

        // FOR EACH percorrendo a lista para UPDATE
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }
        System.out.println("----------------------------");
        System.out.println("Tamanho: " + list.size());
        System.out.println("----update lista----");

        // FOR EACH
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }
        System.out.println("----------------------------");
        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());
        System.out.println("remover por predicado apagar 'M'");
        // PREDICADO - EXPRESAO LAMBIDA (REMOVE (x) TAL QUE 1ª LETRA(x.charAt(0)) == M)
        list.removeIf(x -> x.charAt(0) == 'M');
        // FOR EACH
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }
        System.out.println("----------------------------");
        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());
        System.out.println("Index of Bob: " + list.indexOf("Bob"));
        System.out.println("Index of Bob: " + list.indexOf("Marco"));
        // FOR EACH
        for (String x : list) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }

        System.out.println("----------------------------");
        // imprime tamanho da lista
        System.out.println("Tamanho: " + list.size());

        System.out.println("filtro 'A' - Collettors");
        // PREDICADO - EXPRESAO LAMBIDA( FILTRA (x) TAL QUE 1ª LETRA(x.charAt(0)) == A)
        // usa o collet para converter para tipo List
        List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());

        // FOR EACH
        for (String x : result) {// para cada String (x), contido na lista (list)
            System.out.println(x);// imprima (x), ****listA de STRING****
        }

        System.out.println("---------------------");
        System.out.println("filtro 'B' - Filter.findFirst");
        // PREDICADO - EXPRESAO LAMBIDA( FILTRA (x) TAL QUE 1ª LETRA(x.charAt(0)) == J)
        // findFirst (encontra o 1º) Filtrado "B", orElse se nao encontrar retorna null
        String name = list.stream().filter(x -> x.charAt(0) == 'B').findFirst().orElse(null);
        System.out.println(name);
        System.out.println("---------------------");
        System.out.println("filtro 'J' - Filter.findFirst");
        // PREDICADO - EXPRESAO LAMBIDA( FILTRA (x) TAL QUE 1ª LETRA(x.charAt(0)) == J)
        // findFirst (encontra o 1º) Filtrado "J", orElse se nao encontrar retorna null
        name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
        System.out.println(name);
    }
}