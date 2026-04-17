import java.util.Scanner;

public class M1_UD03_Ex7 {
    public static void main(String[] args) {
        System.out.println("*** Bem Vindo ***");

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos créditos tens?");
        int credits = sc.nextInt();
        candyCalculator(credits);

        sc.close();
    }

    /*
     * Metodo candyCalculator
     * Calcula o máximo de chocolates que podem ser comprados,
     * Calcula o máximo de chicletes que podem ser compradas com o troco restante,
     * bem como o troco a devolver,
     * sabendo que o utilizador quer o maior número de chocolates possível.
     */
    public static void candyCalculator(int credits) {
        int chocolateBarPrice = 5, gumPrice = 3, chocolates = 0, gums = 0;

        // Calcula o máximo de chocolates que podem ser comprados, (
        // Dividindo os créditos pelo preço de um chocolate.)
        chocolates = credits / chocolateBarPrice;
        credits = credits % chocolateBarPrice;

        // Calcula o máximo de chicletes que podem ser compradas com o troco restante,
        // (Dividindo os créditos pelo preço de uma chiclete.)
        gums = credits / gumPrice;
        credits = credits % gumPrice;

        // Imprimir resultados
        if (chocolates > 0) {
            System.out.print(chocolates + " Chocolate(s) ");
        }
        if (gums > 0) {
            System.out.print(gums + " Gum ");
        }
        if (credits > 0) {
            System.out.println(credits + " Troco");
        }
    }
}