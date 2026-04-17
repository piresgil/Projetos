
import java.util.Locale;
import java.util.Scanner;

public class M2_Ex2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);       // Formatação ponto(.) para decimais
        Scanner sc = new Scanner(System.in);        // Entrada de dados


        System.out.println("---Bem-vindo---");
        System.out.println("---Calcular Médias---");
        System.out.println("Digite:");

        // Pede e armazena dados em variaveis
        System.out.print("1ª Nota: ");
        double nota1 = sc.nextDouble();
        System.out.print("2ª Nota: ");
        double nota2 = sc.nextDouble();
        System.out.print("3ª Nota: ");
        double nota3 = sc.nextDouble();

        // Mostra os dados formatados
        System.out.printf("%nMédia: %.2f", calcularMedia(nota1, nota2, nota3));

        sc.close();     // Fecha Scanner
    }

    // Metodo para calcular media
    public static double calcularMedia(double nota1, double nota2, double nota3) {
        return (nota1 + nota2 + nota3) / 3;
    }
}
