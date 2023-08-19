package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of the contract: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        LocalDate date = LocalDate.parse(sc.next(), fmt);
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int installments = sc.nextInt();

        Contract contract = new Contract(number,date,value);

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installments);

        System.out.println("Installments:");
        for (Installment current : contract.getInstallment()){
            System.out.println(current);
        }

        sc.close();
    }
}
