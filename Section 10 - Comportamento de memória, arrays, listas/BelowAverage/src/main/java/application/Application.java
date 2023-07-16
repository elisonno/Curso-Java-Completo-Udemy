package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements will the vector have? ");
        int elements = sc.nextInt();
        boolean noNumbersBelowAverage = false;
        double[] vectorA = new double[elements];
        double sumVector = 0;
        for (int i=0; i<vectorA.length; i++){
            sc.nextLine();
            System.out.print("Enter a number: ");
            vectorA[i] = sc.nextDouble();
            sumVector += vectorA[i];
        }
        double averageVector = sumVector / vectorA.length;
        System.out.printf("Average vector: %.2f\n", averageVector);
        System.out.println("Below Average");
        for (double number: vectorA) {
            if(number < averageVector) {
                System.out.println(number);
                noNumbersBelowAverage = true;
            }
        }
        if(!noNumbersBelowAverage) System.out.println("No numbers below average");


        sc.close();
    }

}
