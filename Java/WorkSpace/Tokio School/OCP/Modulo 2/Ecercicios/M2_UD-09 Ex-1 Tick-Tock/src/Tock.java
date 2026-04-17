public class Tock implements Runnable {

    @Override
    public void run() {
            System.out.println("tock");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

    }
}
