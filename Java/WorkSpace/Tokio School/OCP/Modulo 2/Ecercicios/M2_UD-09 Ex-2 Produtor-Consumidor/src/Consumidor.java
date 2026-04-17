import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
    private final BlockingQueue<Produto> buffer;
    private final int intervalo;

    public Consumidor(BlockingQueue<Produto> buffer, int intervalo) {
        this.buffer = buffer;
        this.intervalo = intervalo;
    }

    @Override
    public void run() {
        try {
            while (true) { // Funcionamento contínuo
                System.out.println("Consumidor vai consumir...");
                Produto produto = buffer.take();
               System.out.println("Consumidor consumiu: " + produto + " - Buffer size: " + buffer.size());
                Thread.sleep(intervalo); // Simula tempo de produção}
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consumidor interrompido!");
        }
    }
}
