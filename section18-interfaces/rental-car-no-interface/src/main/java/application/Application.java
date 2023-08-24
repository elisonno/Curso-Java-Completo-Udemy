package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental details:");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Departure (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), dateTimeFormatter);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), dateTimeFormatter);

        CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter the price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter the price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("FATURA:");
        System.out.println("Pagamento basico: " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f",carRental.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f",carRental.getInvoice().getTotalPayment()));


        sc.close();
    }
}
