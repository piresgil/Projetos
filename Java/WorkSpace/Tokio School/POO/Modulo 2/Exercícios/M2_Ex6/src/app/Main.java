/*
Criar programa que permite ao
utilizador calcular a área de um
triângulo.
O programa também verificará se o
triângulo é equilátero, isósceles ou
escaleno com base nas medidas dos
lados inseridos.
Opcionalmente, procure saber o ângulo
de cada um dos triângulos

********Instruções********

- Exiba uma mensagem introdutória para o utilizador, como "Bem-vindo à Calculadora de Triângulos.".
- Dentro de um loop while, permita ao utilizador escolher entre as seguintes opções:
• Calcular a área do triângulo.
• Calcular os ângulos do triângulo (opcional).
- Peça ao utilizador que insira os comprimentos dos três lados do triângulo (por exemplo, ladoA, ladoB e ladoC).
- Utilize estruturas condicionais para verificar se os comprimentos inseridos formam um triângulo válido (a soma de quaisquer dois
lados deve ser maior que o terceiro lado). Se não formar um triângulo válido, informe ao utilizador e permita que ele insira novos
valores.
- Se os comprimentos dos lados formarem um triângulo válido, permita ao utilizador escolher entre:
• Calcular a área do triângulo.
• Calcular os ângulos do triângulo usando a lei dos cossenos e a lei dos senos (opcional).
- Exiba os resultados calculados (área e ângulos, se selecionados).
- Determine e informe se o triângulo é equilátero (todos os lados iguais), isósceles (dois lados iguais) ou escaleno (todos os lados
diferentes).
- Pergunte ao utilizador se ele deseja realizar outra operação ou sair do programa.

********ENTREGA********

- Escreva o código do programa seguindo as diretrizes fornecidas no enunciado.
- Utilize estruturas condicionais (if-else) para verificar se os comprimentos dos lados formam
um triângulo válido e para realizar cálculos com base nas escolhas do utilizador.
- Utilize um loop while para permitir que o utilizador execute várias operações.
- Verifique se o programa funciona corretamente, permitindo ao utilizador calcular a área e,
opcionalmente, os ângulos do triângulo, e determinar a classificação do triângulo (equilátero,
isósceles ou escaleno).
- Envie o código como um arquivo único com a extensão apropriada (.java para Java, .cs para
C#, .py para Python)
 */

package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangulo;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);   // Formatação ponto(.) para decimais
        Scanner sc = new Scanner(System.in);    // Entrada de dados
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

                    Triangulo triangulo = new Triangulo(ladoA, ladoB, ladoC);   // Instancia novo Triangulo

                    System.out.println("1.Calcular Área do Triangulo");
                    System.out.println("2.Calcular Ângulos do Triangulo");
                    sair = sc.nextInt();

                    if (sair == 1) {    // Calcula a area e salta do Loop
                        System.out.printf("Área: %.4f, ", triangulo.area());
                        triangulo.tipoTriangulo();
                        break;
                    }
                    if (sair == 2) {    // Calcula Angulos e salta do Loop
                        System.out.println("*** Calcular Ângulos do Triangulo ***");
                        triangulo.calculaAngulos(ladoA, ladoB, ladoC);
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
}