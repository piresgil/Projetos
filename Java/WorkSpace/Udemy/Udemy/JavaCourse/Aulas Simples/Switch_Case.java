package application;/*
 * @ Daniel Gil
 */

import java.util.Scanner;

public class Switch_Case {
    /*
    * 
    */
    public static void main(String[] args) {

        /*
         * Fazer um programa para ler um valor inteiro de 1 a 7 representando um
         * dia da semana (sendo 1=domingo, 2=segunda, e assim por diante).
         * Escrever na tela o dia da semana correspondente, conforme exemplos.
         */
        
        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("----exemplo 1 com if e else");
        System.out.println();
        System.out.print("Digite o nº da semana: ");
        int x = sc.nextInt();
        String dia;
        if (x == 1) {
            dia = "domingo";
        } else if (x == 2) {
            dia = "segunda";
        } else if (x == 3) {
            dia = "terça";
        } else if (x == 4) {
            dia = "quarta";
        } else if (x == 5) {
            dia = "quinta";
        } else if (x == 6) {
            dia = "sexta";
        } else if (x == 7) {
            dia = "sabado";
        } else {
            dia = "valor invalido";
        }
        System.out.println("Dia da semana: " + dia);
        System.out.println();

        System.out.println("----exemplo 2 Switch e Case");
        System.out.println();
        System.out.print("Digite o nº da semana: ");
        Scanner sc2 = new Scanner(System.in);
        int y = sc2.nextInt();
        String dia2;
        switch (y) { // seleciona (y)
            case 1: // caso (y) seja de valor 1
                dia2 = "domingo"; // executa o comando
                break; // nececita sempre do brake no final de cada caso (case)
            case 2:
                dia2 = "segunda";
                break;
            case 3:
                dia2 = "terça";
                break;
            case 4:
                dia2 = "quarta";
                break;
            case 5:
                dia2 = "quinta";
                break;
            case 6:
                dia2 = "sexta";
                break;
            case 7:
                dia2 = "sabado";
                break;
            default:
                dia2 = "valor invalido";
                break;
        }
        System.out.println("Dia da semana: " + dia2);
        sc.close();// fechar sempre os Scanner´s no final costuma dar erro fechando antess
        sc2.close();
        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}