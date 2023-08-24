package application;

import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.print("Employee: ");
        employee.name = sc.nextLine();
        System.out.print("Gross salary: ");
        employee.grossSalary = sc.nextDouble();
        System.out.print("Tax: ");
        employee.tax = sc.nextDouble();

        System.out.println(employee);
        System.out.print("Which percentage to increase salary? ");
        employee.increaseSalary(sc.nextDouble());

        System.out.println("Updated data: " + employee);

        sc.close();
    }
}
