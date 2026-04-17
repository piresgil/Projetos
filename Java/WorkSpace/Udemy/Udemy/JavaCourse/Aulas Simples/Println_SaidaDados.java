/*
 * @ Daniel Gil
 */

import java.util.Locale;

    /*
     * 
     */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        System.out.print("Bom dia!");// print nao quebra linha
        System.out.println("Bom dia");// println quebra a linha

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        int y = 32;
        double x = 10.35784;

        System.out.println(y);
        System.out.println(x);

        System.out.println(x);
        System.out.printf("%.2f%n", x);// (%) substitui var x, (.2f) 2 casas decimais
        System.out.printf("%.4f%n", x);// (%n) quebra de linha (%.4f) 4 casas decimais

        Locale.setDefault(Locale.US);// troca a virgula ppor ponto (modo US)
        System.out.printf("%.4f%n", x);// usando o Locale.US

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        /*
         * Regra geral para print e println:
         * elemento1 + elemento2 + elemento3 + ... + elementoN
         */
        System.out.println("RESULTADO = " + x + " METROS");

        /*
         * Regra geral para printf:
         * "TEXTO1 %f TEXTO2 %f TEXTO3", variavel1, variavel2
         */
        System.out.printf("RESULTADO = %.2f metros%n", x);

        /*
         * Regra geral para printf:
         * "TEXTO1 %f TEXTO2 %f TEXTO3", variavel1, variavel2
         * 
         * %f = ponto flutuante
         * %d = inteiro
         * %s = texto
         * %n = quebra de linha
         */

        String nome = "Maria";
        int idade = 31;
        double renda = 4000.0;
        System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome, idade, renda);

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }