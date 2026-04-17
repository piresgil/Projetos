/**
 * Class Tick-Tock
 */
public class TickTock {
    static int timeMax = 30; // 30 segundos

    static void TickTock() {
        for (int i = 0; i < timeMax; i++) {
            System.out.println("tick");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("tock");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}