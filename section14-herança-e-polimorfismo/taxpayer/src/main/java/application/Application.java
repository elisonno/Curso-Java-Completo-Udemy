package application;

import entities.Company;
import entities.Individual;
import entities.Taxpayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        double totalTaxes = 0;
        List<Taxpayer> taxpayerList = new ArrayList<>();
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of taxpayers: ");
        int numberOfTaxpayers = sc.nextInt();
        for(int taxpayer=1; taxpayer<=numberOfTaxpayers; taxpayer++){
            System.out.println("Tax payer #" + taxpayer + " data:");
            System.out.print("Individual or company (i/c)? ");
            char category = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if(category == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxpayerList.add(new Individual(name,anualIncome, healthExpenditures));
            } else{
                System.out.print("Number of employees: ");
                int numberOfEmployee = sc.nextInt();
                taxpayerList.add(new Company(name, anualIncome, numberOfEmployee));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        for(Taxpayer taxpayer : taxpayerList){
            System.out.println(taxpayer.getName() + ": $" + String.format("%.2f",taxpayer.tax()));
            totalTaxes += taxpayer.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalTaxes) );

        sc.close();
    }
}
