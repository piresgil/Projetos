package com.daniel;

public class Main {

    public static void main(String[] args) {

        System.out.println("Primitives Data Types\n");
        System.out.println("int / byte/ short / long\n");

	    int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = myMinValue/2;

        byte myByteValue = 127;
        byte myNewBytevalue = (byte) (myByteValue/2); // adiciona uma cast (byte) para poder fazer a conversão

        short myShortNumber = -32768;

        long myLongNumber = 9_223_372_036_854_775_88L;

        System.out.print("int oschila entre: ");
        System.out.print(myMinValue + " >");
        System.out.println(myMaxValue);
        System.out.print("Byte Number: ");
        System.out.println(myByteValue);
        System.out.print("my new byte valor, with conversion (byte):");
        System.out.println(myNewBytevalue);
        System.out.print("Short Number: ");
        System.out.println(myShortNumber);
        System.out.print("Long Number: ");
        System.out.println(myLongNumber);
        System.out.println("_____________________________________________________________________");


        // 1. Create a byte variable and set it to any valid byte number.
        // 2. Create a short variable and set it to any valid short number.
        // 3. Create a int variable and set it to any valid in number.
        // 4. Create a variable of type long, and make it equal to
        //    50000 + 10 times the sum of the byte, plus the short plus the int

        System.out.println("// 1. Create a byte variable and set it to any valid byte number.\n" +
                "// 2. Create a short variable and set it to any valid short number.\n" +
                "// 3. Create a int variable and set it to any valid in number.\n" +
                "// 4. Create a variable of type long, and make it equal to 50000 + 10 times the sum of the byte, plus the short plus the int\n");

                byte byteValue = 10;
                short shortValue = 20;
                int intValue = 50;

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);

                long lontTotal = 5000L + 10L *(byteValue + shortValue + intValue);
                short shortTotal = (short) (1000 + 10 * (myByteValue + shortValue + intValue));// adiciona um cast (short) para fazer a converção
        System.out.println("Lont total = " + lontTotal);
        System.out.println("Short Number = " + shortTotal);
    }
}
