import java.util.InputMismatchException;
import java.util.Scanner;

public class M3_Ex3 {

    public static void main(String[] args) {

        System.out.println("*** Bem-vindo ***");
        System.out.println("*** Animais ***");
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Escolha um Animal:");
            System.out.println("1.Cão");
            System.out.println("2.Gato");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                System.out.print("Nome: ");
                String nome = sc.next();
                Cao cao = new Cao(nome);
                cao.emitirSom();
                cao.latir();
            }
            if (escolha == 2) {
                System.out.print("Nome: ");
                String nome = sc.next();
                Gato gato = new Gato(nome);
                gato.emitirSom();
                gato.miar();
            }
            if (escolha > 2) {
                System.out.println("Escolha Invalida!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            sc.close();
            System.out.println("*** Sair ***");
        }
    }

    /*
     * Class Animal
     */
    public static class Animal {

        protected String nome;

        public Animal(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void emitirSom() {
            System.out.println("\nO animal emite um som:");
        }
    }

    /*
     * Class Cão
     * Sub-Class de Animal
     */
    public static class Cao extends Animal {

        public Cao(String nome) {
            super(nome);
        }

        public void latir() {
            System.out.println("O cão está latindo.");
        }
    }

    /*
     * Class Gato
     * Sub-Class de Animal
     */
    public static class Gato extends Animal {

        public Gato(String nome) {
            super(nome);
        }

        public void miar() {
            System.out.println("O gato está miando");
        }
    }
}