package application;

import entities.Person;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many people will be typed? ");
        int quantityPeople = sc.nextInt();
        Person[] people = new Person[quantityPeople];
        double sumHeight = 0;
        int peopleUnder16YearsOld = 0;

        for (int i = 0; i < people.length; i++) {
            sc.nextLine();
            switch (i) {
                case 0 -> System.out.println("1st person data:");
                case 1 -> System.out.println("2nd person data: ");
                case 2 -> System.out.println("3rd person data: ");
                default -> System.out.println((i + 1) + "th person data: ");
            }
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Height: ");
            double height = sc.nextDouble();
            people[i] = new Person(name, age, height);

            if (people[i].getAge() < 16) {
                peopleUnder16YearsOld++;
            }
            sumHeight += people[i].getHeight();
        }

        double averageHeight = sumHeight / people.length;
        double percentagePeopleUnder16YearsOld = peopleUnder16YearsOld * 100 / (double)(people.length);
        System.out.println("Average Height: " + String.format("%.2f", averageHeight));
        System.out.println("People under 16 years old: "+ percentagePeopleUnder16YearsOld + "%");

        for (Person person: people){
            if (person.getAge() < 16){
                System.out.println(person.getName());
            }
        }

        sc.close();
    }
}
