package application;

import entities.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();
        System.out.print("Enter rectangle width: ");
        rectangle.widgh = sc.nextDouble();
        System.out.print("Enter rectangle height: ");
        rectangle.height = sc.nextDouble();
        System.out.println(rectangle);

        sc.close();
    }
}
