package application;

import entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        BankAccount client1;
        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String name = sc.nextLine();
        System.out.println("Is there na initial deposit (y/n):");
        if(sc.next().charAt(0) == 'y'){
            System.out.print("Enter initial deposit value: ");
            double value = sc.nextDouble();
            client1 = new BankAccount(accountNumber,name,value);
        }else{
            client1 = new BankAccount(accountNumber,name);
        }

        System.out.println(client1);

        System.out.print("Enter a deposit value: ");
        client1.deposit(sc.nextDouble());

        System.out.println("Update:\n"+ client1);

        System.out.print("Enter a withdraw value: ");
        client1.withdraw(sc.nextDouble());

        System.out.println("Update:\n"+ client1);

        sc.close();

    }
}
