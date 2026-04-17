import java.util.Scanner;

public class M1_UD02_Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** Bem Vindo ***");

        System.out.print("Digite o peso na Terra (kg): ");
        double peso = sc.nextDouble();

        // Operação que converte o pesso na terra no peso na lua
        double pesoLua = peso * 0.17;
        // Imprime
        System.out.printf("Peso na Lua: %.2f kg", pesoLua);

        sc.close();
    }
}