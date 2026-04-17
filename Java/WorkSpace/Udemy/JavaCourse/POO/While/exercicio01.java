/*
 * @ Daniel Gil
 */

 import java.util.Locale;
 import java.util.Scanner;
 
 public class exercicio01 {
     /*
      * Escreva um programa que repita a leitura de uma senha até que ela seja
      * válida. Para cada leitura de senha
      * incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for
      * informada corretamente deve ser
      * impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que
      * a senha correta é o valor 2024.
      */
     public static void main(String[] args) {
         Locale.setDefault(Locale.US);
         Scanner sc = new Scanner(System.in);
        // char sair = ' ';
        // while (sair != 's') {
             System.out.println();
             System.out.println("-----Inicio-----");
             int senha;// 2024
             System.out.print("---Digite a senha: ");
             senha = sc.nextInt();
 
             while (senha != 2024) {
                 System.out.println("SENHA INVALIDA");
                 System.out.print("---Digite a senha: ");
                 senha = sc.nextInt();
             }
             System.out.println("ACESSO PERMITIDO");
 
             System.out.println("-----FIM-----");
        //     System.out.print("------QUER SAI? ");
        //     sair = sc.next().charAt(0);
        // }
         sc.close();
     }
 }