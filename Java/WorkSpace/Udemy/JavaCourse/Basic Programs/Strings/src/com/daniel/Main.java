package com.daniel;

public class Main {

    public static void main(String[] args) {

        System.out.println("exemplo 1");
        System.out.println();
        String myString = "This is String:";
        System.out.println("myString equals: " + myString);
        myString = myString + ", and this is more!";
        System.out.println("myString is qual to: " + myString);
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to: " + myString);
        System.out.println();
        System.out.println("exemplo 2");
        System.out.println();
        String numberString = "250.55";
        numberString = numberString + "49.95";
        System.out.println("the result is : " + numberString);
        System.out.println();
        System.out.println("exemplo 3");
        System.out.println();
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lasString is equals to : " + lastString);
        double doubleNumber = 120.47;
        lastString = lastString + doubleNumber;
        System.out.println("lastString Value : " + lastString);
    }
}
