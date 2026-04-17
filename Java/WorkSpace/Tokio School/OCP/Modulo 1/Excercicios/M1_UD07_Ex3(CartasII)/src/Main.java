/**
 * @author Daniel Gil
 */
public class Main {

    public static void main(String[] args) {

        Baralho baralho = new Baralho();
        Molho molho = baralho.getMolho();
        System.out.println(molho.toString());

        molho.ordena();// ordena ordem natural
        System.out.println(molho.toString());

        molho.ordena(new OrdemNumerosDecrescentes());
        System.out.println(molho.toString());

        molho.ordena(new OrdemNumerosNaipe());
        System.out.println(molho.toString());
    }
}
