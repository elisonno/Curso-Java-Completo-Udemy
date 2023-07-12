package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Name: ");
        student.name = sc.nextLine();
        System.out.print("Enter note 1: ");
        student.note1 = sc.nextDouble();
        System.out.print("Enter note 2: ");
        student.note2 = sc.nextDouble();
        System.out.print("Enter note 3: ");
        student.note3 = sc.nextDouble();

        System.out.println(student);

        sc.close();
    }
}
