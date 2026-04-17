import java.util.Locale;
import java.util.Scanner;

public class M2_Ex7 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);   // Formatação ponto (.) para decimais
        Scanner sc = new Scanner(System.in);    // Entrada de dados

        System.out.println("*** Bem-vindo ao Tabuadex ***");
        System.out.println("Responda correctamente aos problemas de tabuada, e ganhe 10 pontos por resposta correta");

        int pontos = 0;   // Variavel para contar a pontuação
        double resp;    // Variavel para resposta ao problema
        double total;   // Variavel para calcular o total das operções

        System.out.print("Começar Tabuadex (s/n)? ");
        char sair = sc.next().charAt(0);

        /*
         * Loop do programa
         */
        do {
            double nr1 = numero();  // Variavel para armazenar numero 1, Metodo com função random
            double nr2 = numero();  // Variavel para armazenar numero 2, Metodo com função random

            /*
             * Variavel para armazenar resultado da operação, M, Metodo com função random para operação
             */
            total = operacao(nr1, nr2);

            resp = sc.nextDouble(); // Variavel que guarda a resposta do utilizador

            /*
             * Condicinal que testa se a resposta do user é a correcta ou não
             * Atribui pontução e mostra mensssagem.
             */
            if (resp == total) {
                pontos += 10;
                System.out.println("*** Parabéns *** Acertou ***");
                System.out.println("Pontuação: " + pontos);

            } else {
                System.out.printf("*** Resposta Errada *** (resposta correcta, %.2f)\n",total);
                System.out.println("Pontuação: " + pontos);
            }

            System.out.print("Continuar Tabuadex (s/n)? ");
            sair = sc.next().charAt(0); // Variavel do Loop
        } while (sair != 'n');

        sc.close(); // Fecha Scanner
    }

    /*
     * Metodo que atribui um numero aleatorio de 1 até 9
     */
    public static double numero() {
        int nr = (int) (Math.random() * 9 + 1);
        return nr;

    }

    /*
     * Metodo que atribui uma operação aleatoria, calcula e retorna o resultado correto da operação
     */
    public static double operacao(double nr1, double nr2) {
        double total = 0.00;   // Variavel para total do metodo

        int operacao = (int) (Math.random() * 4 + 1);

        switch (operacao) {
            case 1 -> {
                System.out.print(nr1 + " + " + nr2 + " = ");
                total = nr1 + nr2;
            }
            case 2 -> {
                System.out.print(nr1 + " - " + nr2 + " = ");
                total = nr1 - nr2;
            }
            case 3 -> {
                System.out.print(nr1 + " * " + nr2 + " = ");
                total = nr1 * nr2;
            }
            case 4 -> {
                if (nr1 > nr2) {
                    System.out.print(nr1 + " / " + nr2 + " = ");
                    total = nr1 / nr2;
                } else {
                    do {
                        nr1 = (int) (Math.random() * 9 + 1);
                        nr2 = (int) (Math.random() * 9 + 1);
                    } while (nr1 < nr2);
                    System.out.print(nr1 + " / " + nr2 + " = ");
                    total = nr1 / nr2;
                }
            }
        }
        return total;
    }
}