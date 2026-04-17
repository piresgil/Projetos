/*
* @ Daniel Gil
*/

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class App {
    /*
    * 
    */
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();
        // int n = 1;// Hardcode
        List<Shape> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Shape #" + (i + 1) + " data: \n");
            System.out.print("Rectangle or Circle (r/c)? ");
            char charShape = sc.next().charAt(0);
            // char charShape = 'r';// Hardcode

            System.out.print("Color (BLACK/BLUE/RED): ");
            String color = sc.next();
            // String color = "BLACK";// Hardcode
            sc.nextLine();

            if (charShape == 'r' || charShape == 'R') {
                System.out.print("Width: ");
                Double witdth = sc.nextDouble();
                // Double witdth = 5.0;// Hardcode
                System.out.print("Height: ");
                Double height = sc.nextDouble();
                // Double height = 4.0;// Hardcode

                Shape rectangle = new Rectangle(Color.valueOf(color), witdth, height);
                list.add(rectangle);

            } else if (charShape == 'c' || charShape == 'C') {
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();

                Shape circle = new Circle(Color.valueOf(color), radius);
                list.add(circle);
            }
        }

        System.out.println("SHAPE AREAS:");

        for (Shape s : list) {
            System.out.printf("%.2f %n", s.area());
        }
        sc.close();
    }
}