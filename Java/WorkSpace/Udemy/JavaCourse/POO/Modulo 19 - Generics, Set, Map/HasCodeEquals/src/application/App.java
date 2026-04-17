/*
 * @ Daniel Gil
 */
package application;

import entities.Client;

public class App {
    /*
    * HasCode e equals
    */
    public static void main(String[] args) throws Exception {
        String a = "Maria";
        String b = "Alex";
        System.out.println(a.equals(b)); // false

         // HasCode retorna um nº inteiro
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        Client c1 = new Client("Maria","Maria@");
        Client c2 = new Client("Alex","Alex@");

        System.out.println("Hascode:");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println("Equals:");
        System.out.println(c1.equals(c2));

        Client c3 = new Client("Maria","Maria@");
        Client c4 = new Client("Maria","Alex@");

        System.out.println("Hascode:");
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println("Equals:");
        System.out.println(c3.equals(c4));

        Client c5 = new Client("Maria","Maria@");
        Client c6 = new Client("Maria","Maria@");

        System.out.println("Hascode:");
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println("Equals:");
        System.out.println(c3.equals(c4));
        System.out.println(c5 == c6);

        String s1 = "Test";
        String s2 = "Test";

        System.out.println(s1 == s2);

        String s3 = new String("Test");
        String s4 = new String("Test");

        System.out.println(s3 == s4);
    }
}