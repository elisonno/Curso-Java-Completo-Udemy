package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        Department books = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0,books );
        System.out.println(seller);
    }
}
