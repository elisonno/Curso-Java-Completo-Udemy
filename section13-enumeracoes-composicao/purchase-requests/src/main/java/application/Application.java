package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        String nameClient;
        String emailClient;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDateClient;
        String orderStatus;
        int quantityItems;
        Order order;

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        nameClient = sc.nextLine();
        System.out.print("Email: ");
        emailClient = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        birthDateClient = sdf.parse(sc.next());
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        orderStatus = sc.next();
        System.out.print("How many items to this order? ");
        quantityItems = sc.nextInt();
        order = new Order(OrderStatus.valueOf(orderStatus),new Client(nameClient,emailClient,birthDateClient));
        for(int item=1; item<= quantityItems; item++){
            sc.nextLine();
            String nameProduct;
            double priceProduct;
            int quantity;
            System.out.println("Enter #1 item data:");
            System.out.print("Product name: ");
            nameProduct = sc.nextLine();
            System.out.print("Product price: ");
            priceProduct = sc.nextDouble();
            System.out.print("Quantity: ");
            quantity = sc.nextInt();
            order.addItem(new OrderItem(quantity,priceProduct,new Product(nameProduct,priceProduct)));
        }
        System.out.println(order);

        sc.close();
    }
}
