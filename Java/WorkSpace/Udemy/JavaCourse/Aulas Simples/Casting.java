package application;/*
 * @ Daniel Gil
 */

public class Casting {
    /*
    *
    */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();
        /*
         * REGRA:
         * 1) A expressão é calculada
         * 2) O resultado da expressão é armazenado na variável
         */

        System.out.println("Exemplo 1");
        int x, y;
        x = 5;
        y = 2 * x;
        System.out.println(x);
        System.out.println(y);

        System.out.println("Exemplo 2");
        int x1;
        double y1;
        x1 = 5;
        y1 = 2 * x1;
        System.out.println(x1);
        System.out.println(y1);

        System.out.println("Exemplo 3 (Area Trapézios)");
        double b, B, h, area;
        b = 6.0;
        B = 8.0;
        h = 5.0;
        area = (b + B) / 2.0 * h;
        System.out.println(area);
        /*
         * Boa prática:
         * 
         * Sempre indique o tipo do número, se a expressão for de
         * ponto flutuante (não inteira).
         * 
         * Para double use: .0
         * Para float use: f
         */
        System.out.println("Exemplo 4 (nr int 5 /2 sem Casting)");
        int a, z;
        double resultado, resultado2;
        a = 5;
        z = 2;
        resultado = a / z;
        System.out.println(resultado);// resultado vem em numero inteiro
        /*
         * Casting
         * É a conversão explícita de um tipo para outro.
         * É necessário quando o compilador não é capaz de “adivinhar” que o
         * resultado de uma expressão deve ser de outro tipo.
         */

        System.out.println("-----Usando Casting para Double-----");
        resultado2 = (double) a / z;// Casting
        System.out.println(resultado2);
        System.out.println();
        System.out.println("Exemplo 5 (Usando Casting para inteiro)");
        double a2;
        int b2;
        a2 = 5.0;
        b2 = (int) a2;// casting
        System.out.println(b2);

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}