package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many numbers are you going to type? ");
        int quantityNumbers = sc.nextInt();
        int[] numbers = new int[quantityNumbers];
        int evenNumber = 0;

        for (int i=0; i<numbers.length; i++ ){
            sc.nextLine();
            System.out.print("Enter a number: ");
            numbers[i] = sc.nextInt();
        }

        for (int number: numbers){
            if (number % 2 == 0) evenNumber ++;
        }
        if (evenNumber > 0){
            System.out.println("Even Numbers: ");
            for(int number: numbers){
                if(number % 2 == 0) System.out.print(number + " " );
            }
            System.out.println("\nEven Numbers: " + evenNumber);
        }else {
            System.out.println("No Even Number");
        }

        sc.close();
    }
}
