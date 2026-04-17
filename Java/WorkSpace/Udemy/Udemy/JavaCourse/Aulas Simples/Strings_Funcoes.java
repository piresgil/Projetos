/*
 * @ Daniel Gil
 */

package application;

import java.util.Locale;
import java.util.Scanner;

public class Strings_Funcoes {
    /*
     * Operadores bitwise
     * Proggramaçao baixo nivel (microcontroladores, redes, arduino)
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //char sair = ' ';
        //while (sair != 's') {
            System.out.println();
            System.out.println("-----Inicio-----");

            System.out.println();
            System.out.println("-----Strings-----");
            String original = "abcde FGHIJ ABC abc DEFG   ";
            System.out.println("original -" + original + "-");

            // transforma emscaixa baixa(lowe case)
            String s01 = original.toLowerCase();
            System.out.println("toLowerCase: -" + s01 + "-");

            // transforma em caixa alta(Upper case)
            String s02 = original.toUpperCase();
            System.out.println("toUpperCase: -" + s02 + "-");

            // TRIM apaga os espaços anets e depois das letras (ou seja os espaços que podem
            // estar a mais no inicio ou no fim)
            String s03 = original.trim();
            System.out.println("trim: -" + s03 + "-");

            // subString - subtrai string(caracteres) sob o valor no caso (2)
            String s04 = original.substring(2);
            System.out.println("subString(2): -" + s04 + "-");

            // subString - vai recortar a string(caracteres) entre 2 pontos n caso (2, 9)
            String s05 = original.substring(2, 9);
            System.out.println("subString(2, 9): -" + s05 + "-");

            // replace - vai substituir o caracter 'a' no caso pelo 'x'
            String s06 = original.replace('a', 'x');
            System.out.println("replace('a', 'x'): -" + s06 + "-");

            // replace tbm pode substituir o strings "abc" no caso pelo "xy"
            String s07 = original.replace("abc", "xy");
            System.out.println("replace('abc', 'xy'): -" + s07 + "-");

            // indexOf e lastIndexOf - indica a pociçao da string, do inicio(indexOf) ou do
            // final(lastIndexOff)"
            int i = original.indexOf("bc");
            int j = original.lastIndexOf("bc");
            System.out.println("indexOf('bc'): -" + i + "-");
            System.out.println("lastIndexOf('bc'): -" + j + "-");

            System.out.println("-----FIM-----");
        //    System.out.print("------QUER SAI? ");
        //    sair = sc.next().charAt(0);
        //}
        sc.close();
    }
}