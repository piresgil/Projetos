import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.Random;

public class M3_Ex2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("*** Bem-vindo ***");

        Carro car1 = new Carro("Ferrari", 300);
        Carro car2 = new Carro("Porche", 310);
        Carro car3 = new Carro("Bugatti", 325);
        Carro car4 = new Carro("Lamborghini", 350);

        System.out.println("Escolha um carro para a corrida de Carros Simulada");

        try {
            System.out.println("\n1.Ferrari, Velocidade Max: " + car1.getVelocidade() + " km/h");
            System.out.println("2.Porche, Velocidade Max: " + car2.getVelocidade() + " km/h");
            System.out.println("3.Bugatti, Velocidade Max: " + car3.getVelocidade() + " km/h");
            System.out.println("4.Lamborghini, Velocidade Max: " + car4.getVelocidade() + " km/h");
            int escolha = sc.nextInt();

            Carro escolhido;
            switch (escolha) {
                case 1:
                    escolhido = car1;
                    System.out.println("\nCarro escolhido: " + car1.getNome());
                    break;
                case 2:
                    escolhido = car2;
                    System.out.println("\nCarro escolhido: " + car2.getNome());
                    break;
                case 3:
                    escolhido = car3;
                    System.out.println("\nCarro escolhido: " + car3.getNome());
                    break;
                case 4:
                    escolhido = car4;
                    System.out.println("\nCarro escolhido: " + car4.getNome());
                    break;
            }
            corrida(car1, car2, car3, car4);
            System.out.println("\nVencedor: " + Carro.vencedor);

        } catch (InputMismatchException e) {
            System.out.println("Erro de digitação!");
        } finally {
            System.out.println("*** Sair ***");
            sc.close(); // Fecha Scanner
        }
    }

    /*
     * Metodos
     */
    public static void corrida(Carro car1, Carro car2, Carro car3, Carro car4) {
        // Distancia aleatoria
        double distancia = Math.random() * 1000;
        // Simular as corridas
        double tempo1 = car1.correr(distancia);
        double tempo2 = car2.correr(distancia);
        double tempo3 = car3.correr(distancia);
        double tempo4 = car4.correr(distancia);

        //Determinar o vencedor
        if (tempo1 < tempo2 && tempo1 < tempo3 && tempo1 < tempo4) {
            Carro.vencedor = car1.getNome();
        } else if (tempo2 < tempo1 && tempo2 < tempo3 && tempo2 < tempo4) {
            Carro.vencedor = car2.getNome();
        } else if (tempo3 < tempo1 && tempo3 < tempo2 && tempo3 < tempo4) {
            Carro.vencedor = car3.getNome();
        } else {
            Carro.vencedor = car4.getNome();
        }

        // Exibir o vencedor e os tempos
        System.out.println("\n*** Resultados da corrida ***\n");
        System.out.printf("%s, %.3f segundos.\n", car1.getNome(), tempo1);
        System.out.printf("%s, %.3f segundos.\n", car2.getNome(), tempo2);
        System.out.printf("%s, %.3f segundos.\n", car3.getNome(), tempo3);
        System.out.printf("%s, %.3f segundos.\n", car4.getNome(), tempo4);
    }

    /*
     * Class Carro
     */
    static class Carro {

        // Atributos da Class
        static String vencedor;
        private String nome;
        private int velocidade;

        public Carro(String nome, int velocidade) {
            this.nome = nome;
            this.velocidade = velocidade;
        }
        public static String getVencedor() {
            return vencedor;
        }
        public static void setVencedor(String vencedor) {
            Carro.vencedor = vencedor;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public int getVelocidade() {
            return velocidade;
        }
        public void setVelocidade(int velocidade) {
            this.velocidade = velocidade;
        }
        public double correr(double distancia) {
            double tempo = distancia / velocidade;
            return tempo;
        }
    }
}