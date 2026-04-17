package model;

import java.util.*;

/**
 * Class Bag
 */
public class Bag<T> implements Iterable<T> {
    private List<T> items;

    /**
     * Constructor "Padrão",
     * sem @param
     */
    public Bag() {
        this.items = new ArrayList<>();
    }

    /**
     * Method AddLista,
     * Adiciona uma lista <T>, há coleção
     *
     * @param lista <T>
     */
    public void addLista(List<T> lista) {
        if (items.isEmpty()) {
            this.items = lista;
        }
    }

    /**
     * Method Add,
     * Adiciona um elemento há coleção
     *
     * @param item <T>
     */
    public void add(T item) {
        this.items.add(item);
    }

    /**
     * Method clear,
     * elimina todos os itens da coleção
     */
    public void clear() {
        items.clear();
    }

    /**
     * Method contains,
     * boolean para determinar se existe o item na coleção de items
     *
     * @return True se existir o item, false se não existir
     */
    public boolean contains(T item) {
        return items.contains(item);
    }

    /**
     * Method isEmpty
     * Verifica se a coleção está vazia
     *
     * @return true se estiver vazia, false se não estiver
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Method size,
     * verifica o tamanho da coleção
     *
     * @return tamanho da coleção
     */
    public int size() {
        return items.size();
    }

    /**
     * Method Extract
     * Retira da lista um elemento aleatório,
     * com a ajuda da class Random, para sortear um elemento aleatorio
     *
     * @return string sorteada, com o method .random()
     */
    public T extract() {
        if (items.isEmpty()) {
            throw new NoSuchElementException("A coleção esta vazia!");
        }
        items = new ArrayList<>(items);
        Random sortear = new Random();
        int indice = sortear.nextInt(items.size());
        T sorteado = items.get(indice);
        items.remove(indice);
        return sorteado;
    }

    /**
     * Method To String
     *
     * @return texto representativo de uma Bag (lista de "Strings")
     */
    @Override
    public String toString() {
        return "Minha Lista: " + items;
    }

    /**
     * Method Iterator,
     * vai permitir percorrer a coleção (através de um ForEach)
     *
     * @return um Iterator da coleção especifica
     */
    @Override
    public Iterator<T> iterator() {
        // For Each, usando o Iterator
        return new BagIterator();
    }

    /**
     * Class interna para o Iterator da coleção específica
     * percorre a coleção (através de um ForEach)
     *
     * @return HasNext(), percorre coleção dentro do tamanho da coleção
     * @return Next(), incrementa o indice da coleção, para verificar proximo item da coleção
     */
    private class BagIterator implements Iterator<T> {
        private int indice;

        @Override
        public boolean hasNext() {
            return indice < items.size();
        }

        @Override
        public T next() {
            return items.get(indice++);
        }
    }

}
