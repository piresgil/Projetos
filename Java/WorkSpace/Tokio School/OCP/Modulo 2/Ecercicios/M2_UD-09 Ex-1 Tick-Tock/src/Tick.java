public class Tick implements Runnable {

    @Override
    public void run() {
            System.out.println("tick");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
    }
}
