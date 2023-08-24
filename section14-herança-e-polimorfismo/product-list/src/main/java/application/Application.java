package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        int productQuantity;
        List<Product> products = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        productQuantity = sc.nextInt();
        for (int product = 1; product <= productQuantity; product++) {
            char category;
            String name;
            double price;
            System.out.println("Product #" + product + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            category = sc.next().charAt(0);
            sc.nextLine();
            switch (category) {
                case 'i' -> {
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    products.add(new ImportedProduct(name, price, customsFee));
                }
                case 'u' -> {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date date = sdf.parse(sc.next());
                    products.add(new UsedProduct(name, price, date));
                }
                default -> {
                    System.out.print("Name: ");
                    name = sc.nextLine();
                    System.out.print("Price: ");
                    price = sc.nextDouble();
                    products.add(new Product(name, price));
                }
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product product : products) {
            System.out.println(product.priceTag());
        }

        sc.close();


    }
}
