package application;

import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int numberOfEmployee;
        int idIncreaseSalary;
        double percentageIncrease;
        boolean existingID;
        List<Employee> employees = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        numberOfEmployee = sc.nextInt();
        sc.nextLine();

        for (int registration = 0; registration < numberOfEmployee; registration++) {
            int id;
            String name;
            double salary;
            System.out.printf("Emplyee #%d: \n", (registration + 1));
            System.out.print("Id: ");
            id = sc.nextInt();
            sc.nextLine();
            Employee employee = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            if (employee != null) {
                System.out.println("Existing id, register the employee again");
                registration--;
                continue;
            }
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            employees.add(new Employee(id, name, salary));
        }

        do {
            existingID = false;
            System.out.print("Enter the employee id that will have salary increase: ");
            idIncreaseSalary = sc.nextInt();
            sc.nextLine();
            Integer position = positionId(employees, idIncreaseSalary);
            if (position != null) {
                existingID = true;
                System.out.print("Enter the percentage: ");
                percentageIncrease = sc.nextDouble();
                sc.nextLine();
                employees.get(position).increaseSalary(percentageIncrease);
            } else {
                System.out.println("This id does not exist!");
            }
        } while (!existingID);

        System.out.println("List of employees:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        sc.close();
    }

    public static Integer positionId(List<Employee> employees, int id) {
        for (int position = 0; position < employees.size(); position++) {
            if (employees.get(position).getId() == id) {
                return position;
            }
        }
        return null;
    }
}
