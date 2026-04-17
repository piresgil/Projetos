/**
 * @author Daniel Gil
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem vindo ***");

        //TickTock.TickTock();

        Tick tick = new Tick();
        Tock tock = new Tock();
        int time = 30; // 30 segundos
        for (int i = 0; i < time; i++) {
            tick.run();
            tock.run();
        }
    }
}