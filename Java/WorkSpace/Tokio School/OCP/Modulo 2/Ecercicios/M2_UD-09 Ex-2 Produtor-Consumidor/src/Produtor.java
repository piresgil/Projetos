import java.util.concurrent.BlockingQueue;

public class Produtor implements Runnable {
    private final BlockingQueue<Produto> buffer;
    private final int intervalo;

    public Produtor(BlockingQueue<Produto> buffer, int intervalo) {
        this.buffer = buffer;
        this.intervalo = intervalo;
    }

    @Override
    public void run() {
        int id = 1;
        try {
            while (true) { // Funcionamento contínuo
                System.out.println("Produtor vai produzir...");
                Produto produto = new Produto("Produto " + id++); // Cria um novo produto
                System.out.println("Produtor vai produzir: " + produto);
                buffer.put(produto);
               System.out.println("Produtor produziu: " + produto + " - Buffer size: " + buffer.size());
                Thread.sleep(intervalo); // Simula tempo de produção}
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
