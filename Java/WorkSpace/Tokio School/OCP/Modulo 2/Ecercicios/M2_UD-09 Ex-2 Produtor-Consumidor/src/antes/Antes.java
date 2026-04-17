package antes;

import java.util.ArrayList;
import java.util.List;

public class Antes {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Produto p1 = new Produto("A");
        List<Produto> lista = new ArrayList<>();
        int capacidade = 5;
        System.out.println(lista);

        Thread produtor = new Thread(new Produtor(lista, p1, capacidade));
        Thread consumidor = new Thread(new Consumidor(lista, p1, capacidade));

        produtor.start();
        consumidor.start();

        // Inicializar o buffer partilhado como uma ArrayBlockingQueue com capacidade limitada
        // BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(capacidade);
        //
        // for (int i = 0; i < capacidade; i++) {
        //     Thread produtor = new Thread(new Produtor(buffer));
        //     produtor.start();
        //     System.out.println(lista);
        // }
        // Thread consumidor = new Thread(new Consumidor(buffer));
        // consumidor.start();
        // System.out.println(lista);


        //    for (int i = 0; i < capacidade; i++) {
        //        Produtor produtor = new Produtor(lista,p1,4);
        //        produtor.run();
        //         System.out.println(lista);
        //        Consumidor consumidor = new Consumidor(lista,p1,4);
        //        consumidor.run();
        //    }


        //  for (int i = 0; i < capacidade; i++) {
        //      Produtor produtor = new Produtor(lista, p1, 4);
        //      produtor.run();
        //      System.out.println(lista);
        //  }
        //
        //  // System.out.println(lista);
        //
        //  for (int i = 0; i < capacidade; i++) {
        //
        //      Consumidor consumidor = new Consumidor(lista, p1, 4);
        //      consumidor.run();
        //      System.out.println(lista);
        //  }
        //

        // System.out.println(lista);
    }
}

class Produto {
    String Nome;

    public Produto(String nome) {
        Nome = nome;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: '" + Nome + '\'';
    }
}

class Consumidor implements Runnable {

    private final List<Produto> produtos;
    private final Produto produto;

    private final int capacidade;

    public Consumidor(List produtos, Produto produto, int capacidade) {
        this.produtos = produtos;
        this.produto = produto;
        this.capacidade = capacidade;
    }

    public Produto getProduto() {
        return produto;
    }
    @Override
    public void run() {

        if (produtos.isEmpty()) {
            System.out.println("A Lista está vazia");
        } else if (produtos.size() <= capacidade) {
            produtos.remove(getProduto());
        }
    }

}

class Buffer {
    private final List<Produto> lista;
    private final int capacidade;

    public Buffer(int capacidade) {
        this.lista = new ArrayList<>();
        this.capacidade = capacidade;
    }

    public synchronized void produzir(Produto produto) throws InterruptedException {
        while (lista.size() == capacidade) {
            System.out.println("Produtor esperando - Lista cheia.");
            wait(); // Espera até que haja espaço
        }
        lista.add(produto);
        System.out.println("Produtor produziu: " + produto + " - Tamanho: " + lista.size());
        notifyAll(); // Notifica os consumidores que há um novo item
    }

    public synchronized Produto consumir() throws InterruptedException {
        while (lista.isEmpty()) {
            System.out.println("Consumidor esperando - Lista vazia.");
            wait(); // Espera até que haja um item
        }
        Produto produto = lista.remove(0); // Remove o primeiro item (FIFO)
        System.out.println("Consumidor consumiu: " + produto + " - Tamanho: " + lista.size());
        notifyAll(); // Notifica os produtores que há espaço disponível
        return produto;
    }
}


class Produtor implements Runnable {

    private final List<Produto> produtos;
    private final Produto produto;
    private final int capacidade;

    public Produtor(List produtos, Produto produto, int capacidade) {
        this.produtos = produtos;
        this.produto = produto;
        this.capacidade = capacidade;
    }

    public Produto getProduto() {
        return produto;
    }

    @Override
    public void run() {
        if (produtos.size() < capacidade) {
            produtos.add(getProduto());
        } else {
            System.out.println("A Lista está cheia");
        }
    }
}