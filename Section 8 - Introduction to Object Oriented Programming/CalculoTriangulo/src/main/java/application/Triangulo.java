package application;

import java.util.Locale;
import java.util.Scanner;

public class Triangulo {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double xA, xB, xC, yA, yB, yC, p;

        System.out.println("Enter the measures of triangle X:");
        System.out.print("xA: ");
        xA=sc.nextDouble();
        System.out.print("xB: ");
        xB=sc.nextDouble();
        System.out.print("xC: ");
        xC=sc.nextDouble();

        System.out.println("Enter the measures of triangle Y:");
        System.out.print("yA: ");
        yA=sc.nextDouble();
        System.out.print("yB: ");
        yB=sc.nextDouble();
        System.out.print("yC: ");
        yC=sc.nextDouble();

        p = (xA + xB + xC)/2.0;
        double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

        p = (yA + yB + yC)/2.0;
        double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

        System.out.printf("Triangle X area: %.4f\n", areaX);
        System.out.printf("Triangle Y area: %.4f\n", areaY);

        if(areaX == areaY){
            System.out.println("Triangles with equal areas");
        }else if(areaX > areaY){
            System.out.println("Larger area: Triangle X");
        }else{
            System.out.println("Larger area: Triangle Y");
        }

        System.out.println();

        sc.close();
    }
}
