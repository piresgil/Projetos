/*
 *  @ Daniel Gil
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aula_170_TryCatch {
    /*
    *  
    */
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("______________Inicio______________");

        System.out.print("---Digite alguns nomes no vect: ");
        String[] vect = sc.nextLine().split(" ");
        try {
            System.out.print("---Possição no vect: ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        } catch (ArrayIndexOutOfBoundsException e) {// exepção fora do array (posição)
            System.out.println("Invalid position");
        } catch (InputMismatchException e) {
            {// exepção deve ter digitado uma letra em vez d um nº
                System.out.println("Input Error");
            }
            sc.close();
            System.out.println("______________Final______________");
        }
    }
}