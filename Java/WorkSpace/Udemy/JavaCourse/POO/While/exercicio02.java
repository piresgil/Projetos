/*
 * @ Daniel Gil
 */

 import java.util.Locale;
 import java.util.Scanner;
 
 public class exercicio02 {
     /*
      * Escreva um programa para ler as coordenadas (X,Y) de uma quantidade
      * indeterminada de pontos no sistema
      * cartesiano. Para cada ponto escrever o quadrante a que ele pertence. O
      * algoritmo será encerrado quando pelo
      * menos uma de duas coordenadas for NULA (nesta situação sem escrever mensagem
      * alguma).
      */
     public static void main(String[] args) {
         Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);
         //char sair = ' ';
         //while (sair != 's') {
             System.out.println();
             System.out.println("-----Inicio-----");
             int x, y;// 2024
             System.out.print("---Digite as cordenadaas 'X e 'Y: ");
             x = sc.nextInt();
             y = sc.nextInt();
 
             while (x != 0 && y != 0) {
 
                 if (x > 0 && y > 0) {
                     System.out.println("Quadrante 1");
                 } else if (x > 0 && y < 0) {
                     System.out.println("Quadrante 4");
                 } else if (x < 0 && y < 0) {
                     System.out.println("Quadrante 3");
                 } else if (x < 0 && y > 0) {
                     System.out.println("Quadrante 2");
 
                 }
                 System.out.print("---Digite as cordenadaas 'X e 'Y: ");
                 x = sc.nextInt();
                 y = sc.nextInt();
             }
             System.out.println("-----FIM-----");
             //System.out.print("------QUER SAI? ");
             //sair = sc.next().charAt(0);
         //}
         sc.close();
     }
 }