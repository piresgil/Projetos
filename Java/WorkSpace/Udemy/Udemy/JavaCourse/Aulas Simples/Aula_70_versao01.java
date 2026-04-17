package application;/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

public class Aula_70_versao01 {
    /*
     * Problema exemplo Versao-01(metodos na propria classe teem que ser static)
     *
     * Fazer um programa para ler um valor numérico qualquer, e daí mostrar
     * quanto seria o valor de uma circunferência e do volume de uma esfera
     * para um raio daquele valor. Informar também o valor de PI com duas
     * casas decimais
     */
    public static final double PI = 3.14159; // Costante, padrao com caixa alta(caps lock)

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = circumference(radius);
        double v = volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", PI);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }

    //(metodos na propria classe teem que ser static) pois o main é static...
    public static double circumference(double radius) {
        return 2.00 * PI * radius;
    }

    public static double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}


class Aula_70_versao02 {
    /*
     * Problema exemplo
     * Versao-02(metodos econstante na class calculator e sem membros static)
     *
     * Fazer um programa para ler um valor numérico qualquer, e daí mostrar
     * quanto seria o valor de uma circunferência e do volume de uma esfera
     * para um raio daquele valor. Informar também o valor de PI com duas
     * casas decimais
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        CalculatorV2 calc = new CalculatorV2();
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double c = calc.circumference(radius);
        double v = calc.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", calc.PI);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}


class Aula_70_versao03 {
    /*
     * Problema exemplo
     * Versao-02(metodos e constante na class CalculatorV2 e sem membros static)
     *
     * Fazer um programa para ler um valor numérico qualquer, e daí mostrar
     * quanto seria o valor de uma circunferência e do volume de uma esfera
     * para um raio daquele valor. Informar também o valor de PI com duas
     * casas decimais
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        //nao precisa criar var para is buscar o calculator...basta chamar pela class.
        double c = CalculatorV3.circumference(radius);
        double v = CalculatorV3.volume(radius);

        System.out.printf("Circumference: %.2f%n", c);
        System.out.printf("volume: %.2f%n", v);
        System.out.printf("PI value: %.2f%n", CalculatorV3.PI);

        System.out.println();
        System.out.println("-----FIM-----");
        // System.out.print("------QUER SAI? ");
        // sair = sc.next().charAt(0);
        // }
        sc.close();
    }
}

class CalculatorV2 {
    /*
     * sem membros static, funcionando ao chamar o obj na class principal, precisa
     * criar uma varialvel
     */
    public final double PI = 3.14159; // Costante, padrao com caixa alta(caps lock)

    public double circumference(double radius) {
        return 2.00 * PI * radius;
    }

    public double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}


class CalculatorV3 {
    /*
     * com membros static, funciona chamando apenas a classdestinada neste caso
     * (CalculatorV3)
     */
    public static final double PI = 3.14159; // Costante, padrao com caixa alta(caps lock)

    public static double circumference(double radius) {
        return 2.00 * PI * radius;
    }

    public static double volume(double radius) {
        return 4.0 * PI * radius * radius * radius / 3.0;
    }
}