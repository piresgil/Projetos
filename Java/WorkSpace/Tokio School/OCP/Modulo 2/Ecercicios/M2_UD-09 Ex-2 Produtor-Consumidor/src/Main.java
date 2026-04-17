import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private static final int CAPACIDADE_BUFFER = 5;
    private static final int INTERVALO_PRODUCAO = 500; // Milissegundos
    private static final int INTERVALO_CONSUMO = 800;  // Milissegundos

    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");
        System.out.println("*** Simulação Produtor-Consumidor ***");

        BlockingQueue<Produto> buffer = new LinkedBlockingQueue<>(CAPACIDADE_BUFFER);

        Thread produtorThread = new Thread(new Produtor(buffer, INTERVALO_PRODUCAO));
        Thread consumidorThread = new Thread(new Consumidor(buffer, INTERVALO_CONSUMO));

        produtorThread.start();
        consumidorThread.start();

        // O programa funcionará continuamente até ser interrompido manualmente (Ctrl+C, por exemplo)
    }
}
