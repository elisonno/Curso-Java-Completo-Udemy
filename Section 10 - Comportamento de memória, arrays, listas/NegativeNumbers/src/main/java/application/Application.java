package application;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many numbers are you going to type? ");
        int quantityNumbers = sc.nextInt();
        int[] numbers = new int[quantityNumbers];

        for(int i=0; i<numbers.length; i++){
            sc.nextLine();
            System.out.print("Enter a number: ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("-------Negative Numbers-------");
        boolean negativeNumber = false;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] <0) {
                System.out.println(numbers[i]);
                negativeNumber = true;
            }
        }
        if(!negativeNumber) System.out.println("No Negative Numbers");
        sc.close();
    }
}
