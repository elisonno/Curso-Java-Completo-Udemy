package application;

import entities.Rent;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many rooms will be rented? ");
        int rentedRooms = sc.nextInt();
        Rent hostel = new Rent();
        for (int i=0; i<rentedRooms; i++ ){
            sc.nextLine();
            System.out.println("Rent #" +(i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("E-mail: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            int room = sc.nextInt();

            hostel.rentRoom(room,name,email);
        }

        hostel.showRentedRooms();

        sc.close();
    }

}
