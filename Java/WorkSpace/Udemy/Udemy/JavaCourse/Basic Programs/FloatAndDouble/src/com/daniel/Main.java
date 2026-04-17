package com.daniel;

public class Main {

    public static void main(String[] args) {
        System.out.println("Primitive types");
        System.out.println("Float / Double");
        System.out.println("__________________________________________");

        int myIntValue = 5;
        int myValueInt = 5 / 2;
        float myFloatValue = 5;
        float myValueFloat = 5f;
        float realFloat = 5f / 3f;
        double myDoubleValue = 5.25;
        double myValueDouble = 5d;
        double realDouble = 5d / 3d;
        System.out.println("int: " + myIntValue + "/2 =  " + myValueInt);
        System.out.println("Float: " + myFloatValue);
        System.out.println("Float 5f" + myValueFloat);
        System.out.println("Double: " + myDoubleValue);
        System.out.println("Double 5d : " + myValueDouble);
        System.out.println("Other Float number: " + realFloat + " Other double number: " + realDouble);
        System.out.println("__________________________________________");

        System.out.println("Convert a given number of pounds to kilograms\n" +
                "1. Create a variable to store the number of pounds\n" +
                "2. Calculate the number of Kilograms for the number above and store in a variable.\n" +
                " 3. Print out the result.\n" +
                "\n" +
                "NOTES: 1 pound is equal to 0.45359237 kilograms.");

            double numPaunds = 200d;
            double convertedKlilos = numPaunds * 0.45359237d;
        System.out.println("Kilosgramas: " + convertedKlilos);





    }
}
