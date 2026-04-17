package application;/*
 * @ Daniel Gil
 */

import java.util.Scanner;

public class While {
    /*
     * Estrutura repetitiva "enquanto"
     * 
     * É uma estrutura de controle que
     * repete um bloco de comandos
     * enquanto uma condição for
     * verdadeira.
     * Quando usar: quando não se
     * sabe previamente a quantidade
     * de repetições que será realizada.
     */

    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um nº: ");
        int x = sc.nextInt();
        int soma = 0;
        /*
         * Regra:
         * testa uma condição, e se essa condição for:
         * Verdadeira: executa e volta
         * Falsa: pula fora
         * -> Programa vai ler um nº até ser (0) e saltar fora.
         * Vai ainda fazer uma soma dos numeros foram digitados
         * ate ser (0) e parar.
         */
        while (x != 0) {
            System.out.print("Digite um nº: ");
            soma = soma + x;
            x = sc.nextInt();
        }
        System.out.print("Os seus nº somados são: " + soma);

        sc.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}