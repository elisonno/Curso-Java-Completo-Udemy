package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int number;
        String holder;
        double balance;
        double withdrawLimit;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            holder = sc.nextLine();
            System.out.print("Initial balance: ");
            balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            withdrawLimit = sc.nextDouble();
            Account account1 = new Account(number,holder,balance,withdrawLimit);
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            account1.withdraw(sc.nextDouble());

            System.out.println("New Balance: " + account1.getBalance());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }
        sc.close();
    }
}
