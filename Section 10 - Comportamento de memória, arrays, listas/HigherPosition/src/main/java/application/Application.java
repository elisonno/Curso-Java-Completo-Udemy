package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers are you going to type? ");
        int quantityOfNumbers = sc.nextInt();
        double[] numbers = new double[quantityOfNumbers];
        double highestValue = 0;
        int higherPosition = 0;
        for (int i =0; i<numbers.length; i++){
            sc.nextLine();
            System.out.print("Enter a number: ");
            numbers[i] = sc.nextInt();
        }
        for (int i=0; i<numbers.length; i++){
            if(numbers[i] > highestValue){
                highestValue = numbers[i];
                higherPosition = i;
            }
        }

        System.out.println("Highest Value: " + highestValue);
        System.out.println("Higher Position: " + higherPosition);

        sc.close();
    }
}
