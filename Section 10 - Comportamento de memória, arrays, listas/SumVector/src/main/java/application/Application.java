package application;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers are you going to type? ");
        int quantityNumbers = sc.nextInt();
        double[] numbers = new double[quantityNumbers];
        double sum =0;

        for(int i=0; i<numbers.length; i++){
            sc.nextLine();
            System.out.print("Enter a number: ");
            numbers[i] = sc.nextDouble();
            sum += numbers[i];
        }
        double average = sum / /*(double)*/ numbers.length;
        System.out.print("Values: [");
        for(int i=0; i<numbers.length; i++){
            if (i == (numbers.length - 1)) {
                System.out.print(numbers[i] + "]");
            }else {
                System.out.print(numbers[i] + " | ");
            }

        }
        System.out.printf("\nSUM: %.2f \nAVERAGE: %.2f", sum, average);


        sc.close();
    }
}
