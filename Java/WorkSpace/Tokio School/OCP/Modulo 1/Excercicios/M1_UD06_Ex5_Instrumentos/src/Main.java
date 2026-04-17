/**
 * @author Daniel Gil
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Orquestra orq = new Orquestra();
        orq.tocar("DO");
        System.out.println();
        orq.tocar("RE");
        System.out.println();
        orq.tocar("MI");
        System.out.println();
        orq.tocar("SOL");
        System.out.println();
        orq.tocar("LA");
        System.out.println();
        orq.tocar("FA");
        System.out.println();
        orq.tocar("SI");
    }
}