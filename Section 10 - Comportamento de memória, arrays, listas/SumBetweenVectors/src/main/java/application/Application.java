package application;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many values will each vector have? ");
        int qunatityNumbers = sc.nextInt();
        int[] vectorA = new int[qunatityNumbers];
        int[] vectorB = new int[qunatityNumbers];
        int[] vectorC = new int[qunatityNumbers];

        System.out.println("Enter the values of vector A");
        for (int i=0; i<vectorA.length; i++){
            sc.nextLine();
            vectorA[i] = sc.nextInt();
        }
        System.out.println("Enter the values of vector B");
        for (int i=0; i<vectorB.length; i++){
            sc.nextLine();
            vectorB[i] = sc.nextInt();
        }

        for (int i=0; i<vectorC.length; i++){
            vectorC[i] = vectorA[i] + vectorB[i];
        }
        System.out.println("Resulting Vector");
        for(int sum : vectorC){
            System.out.println(sum);
        }

        sc.close();
    }
}
