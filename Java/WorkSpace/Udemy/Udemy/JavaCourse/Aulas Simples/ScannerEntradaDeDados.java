package application;/*
 * @ Daniel Gil
 */

import java.util.Locale;
import java.util.Scanner;

class Scanner_EntradaDeDados {
    /*
     *
     */
    public static void main(String[] args) {

        /* Para ler um texto até A QUEBRA DE LINHA */

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("----Digite ate quebra de linha (ENTER) com o nextLine()");
        String s1, s2, s3;
        s1 = sc.nextLine();//
        s2 = sc.nextLine();
        s3 = sc.nextLine();
        System.out.println();
        System.out.println("---DADOS DIGITADOS:");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        /*
         * ATENÇÃO: quebra de linha pendente
         *
         * Quando você usa um comando de leitura diferente do nextLine() e
         * dá alguma quebra de linha, essa quebra de linha fica "pendente" na entrada
         * padrão.
         * Se você então fizer um nextLine(), aquela quebra de linha pendente será
         * absorvida pelo nextLine().
         * Solução:
         * Faça um nextLine() extra antes de fazer o nextLine() de seu interesse.
         */

        int x;
        String z1, z2, z3;

        System.out.println("----Digite ate quebra de linha (ENTER)");
        System.out.println("----1 inteiro com nextInt() e 3 strings com nextLine()");
        x = sc.nextInt();// precisa consumir a linha que fica pendente aqui do nextInt()
        sc.nextLine();// com mais um nextLine() comsome a quebra de linha q fica pendente do nextInt()
        z1 = sc.nextLine();
        z2 = sc.nextLine();
        z3 = sc.nextLine();
        System.out.println("DADOS DIGITADOS:");
        System.out.println(x);
        System.out.println(z1);
        System.out.println(z2);
        System.out.println(z3);
        sc.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}

public class ScannerEntradaDeDados {
    /*
    * 
    */
    public static void main(String[] args) {

        System.out.println();
        System.out.println("-----Inicio-----");
        System.out.println();

        Scanner sc = new Scanner(System.in);// icinia sistema de leitura de dados
        System.out.println(".next() leitura de strings");
        String x;
        x = sc.next();
        System.out.println("---Voce digitou " + x);
        System.out.println();
        Scanner scint = new Scanner(System.in);
        System.out.println(".nextInt() leitura de inteiros");
        int y;
        y = scint.nextInt();
        System.out.println("---Voce digitou " + y);
        System.out.println();
        Scanner scdouble = new Scanner(System.in);
        System.out.println(".nextDouble() leitura de Double(com virgula)");
        double z;
        z = scdouble.nextDouble();
        System.out.println("---Voce digitou " + z);
        System.out.println();
        Locale.setDefault(Locale.US);
        Scanner scdouble2 = new Scanner(System.in);
        System.out.println(".nextDouble(), usando Locale(US) e Printf ");
        double z2;
        z2 = scdouble2.nextDouble();
        System.out.printf("---Voce digitou %.2f%n", z2);
        System.out.println();
        System.out.println("char, le o primeiro caracter");
        Scanner scchar = new Scanner(System.in);
        System.out.println(".next().charAt(0)");
        char ch;
        ch = scchar.next().charAt(0);
        System.out.println("---Voce digitou " + ch);
        System.out.println();

        /* Para ler vários dados na mesma linha */
        Scanner sc3 = new Scanner(System.in);
        String l;
        int k;
        double j;
        System.out.println("---Digite na mesma linha separado por espaço");
        System.out.println("---1 string, 1 inteiro e 1 double");
        l = sc3.next();
        k = sc3.nextInt();
        j = sc3.nextDouble();
        System.out.println("---Dados digitados:");
        System.out.println(l);
        System.out.println(k);
        System.out.println(j);

        sc.close();// fecha sistema de leitura de dados
        scint.close();
        scdouble.close();
        scdouble2.close();
        scchar.close();
        sc3.close();

        System.out.println();
        System.out.println("-----FIM-----");
        System.out.println();
    }
}