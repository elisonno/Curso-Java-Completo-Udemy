package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        Set<Integer> courseA = new HashSet<>();
        Set<Integer> courseB = new HashSet<>();
        Set<Integer> courseC = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students for course A? ");
        int studentsOfCourse = sc.nextInt();
        for(int i=1; i <=studentsOfCourse; i++){
            sc.nextLine();
            courseA.add(sc.nextInt());
        }

        System.out.print("How many students for course B? ");
        studentsOfCourse = sc.nextInt();
        for(int i=1; i <=studentsOfCourse; i++){
            sc.nextLine();
            courseB.add(sc.nextInt());
        }
        System.out.print("How many students for course C? ");
        studentsOfCourse = sc.nextInt();
        for(int i=1; i <=studentsOfCourse; i++){
            sc.nextLine();
            courseC.add(sc.nextInt());
        }
        Set<Integer> totalStudent = new HashSet<>(courseA);
        totalStudent.addAll(courseB);
        totalStudent.addAll(courseC);

        System.out.println("Total students: " + totalStudent.size());
        sc.close();

    }
}
