/*
 *  @ Daniel Gil
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aula_171_TryCatch {
  /*
  * 
  */
  public static void main(String[] args) throws Exception {

    System.out.println("______________Inicio______________");

    method1();

    System.out.println("______________Final______________");
  }

  public static void method1() {
    System.out.println("---Start Method1---");
    method2();
    System.out.println("---Start Method1---");
  }

  public static void method2() {

    Scanner sc = new Scanner(System.in);
    try {
      System.out.println("---Start Method2---");

      System.out.print("---Digite alguns nomes no vect: ");
      String[] vect = sc.nextLine().split(" ");

      System.out.print("---Possição no vect: ");
      int position = sc.nextInt();
      System.out.println(vect[position]);

    } catch (ArrayIndexOutOfBoundsException e) { // exepção fora do array (posição)
      System.out.println("Invalid position");
      e.getStackTrace(); // rastreia o erro

    } catch (InputMismatchException e) { // exepção deve ter digitado uma letra em vez d um nº
      System.out.println("Input Error");
    }
    sc.close();
    System.out.println("---FINAL Method2---");
  }
}