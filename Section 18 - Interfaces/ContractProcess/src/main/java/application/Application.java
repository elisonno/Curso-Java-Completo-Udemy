package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the details of the contract: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        System.out.print("Enter the number of installments: ");
        int installments = sc.nextInt();

        Contract contract = new Contract(number,date,value);

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installments);

        System.out.println("Installments:");
        for (Installment current : contract.getInstallment()){
            System.out.println(sdf.format(current.getDueDate()) + " - $" + String.format("%.2f", current.getAmount()));
        }

        sc.close();
    }
}
