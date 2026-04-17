import java.util.Locale;
import java.util.Scanner;

public class M2_Ex6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    //Entrada de dados
        Locale.setDefault(Locale.US);   //Formatação ponto(.) para decimais
        System.out.println("*** Bem-vindo à Calculadora de Triângulos ***");
        int sair;   // variavel para respostas

        do {    // Inicia Loop, para sair (!= 0)

            System.out.println("*** Lados do Triangulo ***");
            System.out.print("Lado A: ");
            double ladoA = sc.nextDouble(); // entrada de dados
            System.out.print("Lado B: ");
            double ladoB = sc.nextDouble(); // entrada de dados
            System.out.print("Lado C: ");
            double ladoC = sc.nextDouble(); // entrada de dados

            do {
                /* Validação de Triangulo, com Loop e condicionais,
                 * Enquanto Não for um triangulo, executa Loop
                 * Quando for um triangulo, pede para calcular area ou angulos
                 * Apresenta resultados e salta do loop de validação de Triangulo
                 */

                if ((validaTriangulo(ladoA, ladoB, ladoC) == true)) {   // Se for um Triangulo, Pede a operção

                    System.out.println("1.Calcular Área do Triangulo");
                    System.out.println("2.Calcular Ângulos do Triangulo");
                    sair = sc.nextInt();

                    if (sair == 1) {    // Calcula a area e salta do Loop
                        System.out.printf("Área: %.4f, ", area(ladoA, ladoB, ladoC));
                        tipoTriangulo(ladoA, ladoB, ladoC);
                        break;
                    }
                    if (sair == 2) {    // Calcula Angulos e salta do Loop
                        System.out.println("*** Calcular Ângulos do Triangulo ***");
                       calculaAngulos(ladoA, ladoB, ladoC);
                        break;
                    }

                } else if ((validaTriangulo(ladoA, ladoB, ladoC) == false)) {
                    /* Se Não for um triangulo
                     * pede os lados de novo
                     * enquanto nao for um triangulo fica em loop
                     */

                    System.out.println("*** Triangulo Inválido ***");
                    System.out.println("*** Digite novamente ***");
                    System.out.print("Lado A: ");
                    ladoA = sc.nextDouble();
                    System.out.print("Lado B: ");
                    ladoB = sc.nextDouble();
                    System.out.print("Lado C: ");
                    ladoC = sc.nextDouble();
                }
            } while (validaTriangulo(ladoA, ladoB, ladoC) == true);

            System.out.println();
            System.out.println("1.Calcular novo Triangulo");
            System.out.println("0.Sair");
            sair = sc.nextInt();

        } while (sair != 0);

        System.out.println("*** Sair ***");
        sc.close();
    }

    // Metodo que verifica se é um triangulo
    public static boolean validaTriangulo(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {   // Lados nulos
            return false;
        }
        if (a >= b + c || b >= a + c || c >= a + b) {   // Triangulo inexistente
            return false;
        }
        return true;
    }
    // Metodo que verifica o tipo de triangulo
    public static void tipoTriangulo(double a, double b, double c) {   // Metodo para validar tipo de triangulo

        if (a == b && b == c)
            System.out.println("Triangulo equilátero."); // todos lados iguais

        else if (a == b || b == c || c == a)
            System.out.println("Triangulo isósceles."); // 2 lados iguais

        else
            System.out.println("Triangulo escaleno.");  // todos lados diferentes
    }

    // Metodo que Calcula a area de um triangulo
    public static double area(double a, double b, double c) {  // Metodo para calcular area
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Metodo para calcular os ângulos usando a Lei dos Cossenos
    public static void calculaAngulos(double a, double b, double c) {
        double anguloA = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2 * b * c)));
        double anguloB = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2 * a * c)));
        double anguloC = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2 * a * b)));

        System.out.printf("Ângulo A: %.2f graus%n", anguloA);
        System.out.printf("Ângulo B: %.2f graus%n", anguloB);
        System.out.printf("Ângulo C: %.2f graus%n", anguloC);
    }
}