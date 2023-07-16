package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many values will each vector have? ");
        int quantityNumbers = sc.nextInt();
        int[] vectorNumbers = new int[quantityNumbers];
        int countEven = 0;
        int sumEven = 0;
        for (int i = 0; i < vectorNumbers.length; i++) {
            sc.nextLine();
            System.out.print("Enter a number: ");
            vectorNumbers[i] = sc.nextInt();
        }
        for (int even : vectorNumbers) {
            if (even % 2 == 0) {
                countEven++;
                sumEven += even;
            }
        }
        if (countEven > 0) {
            double evenAverage = (double) sumEven / countEven;
            System.out.println("Even Average: " + evenAverage);
        } else {
            System.out.println("No Even Number");
        }
        sc.close();
    }
}
