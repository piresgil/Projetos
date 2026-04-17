import java.util.Scanner;

public class M1_UD03_Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Bem Vindo ***");

        System.out.print("Números primos até: ");
        int nrMaximo = 100;
        // int nrMaximo = sc.nextInt();
        nrMaximo = 100;
        System.out.println(nrMaximo);

        for (int i = 2; i <= nrMaximo; i++) {
            if (primo(i)) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }

    /*
     *  Metodo
     *  Verifica se é numero primo
     */
    public static boolean primo(int numero) {
        if (numero <= 1) {
            return false; // condição inteiro positivo
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) { // resto da divisão zero, da raiz quadrada do número
                return false;
            }
        }
        return true;
    }
}