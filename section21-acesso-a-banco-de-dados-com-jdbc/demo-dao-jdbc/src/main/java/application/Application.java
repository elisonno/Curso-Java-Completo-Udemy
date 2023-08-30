package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("--- TEST 1: seller findById ---");
        Seller sellerTest1 = sellerDao.findById(3);
        System.out.println(sellerTest1);

        System.out.println("\n--- TEST 2: seller findByDepartment ---");
        Department departmentTest2 = new Department(2, null);
        List<Seller> sellers = sellerDao.findByDepartment(departmentTest2);
        for (Seller sellerTest2 : sellers) {
            System.out.println(sellerTest2);
        }

        System.out.println("\n--- TEST 3: seller findAll ---");
        sellers = sellerDao.findAll();
        for (Seller sellerTest3 : sellers) {
            System.out.println(sellerTest3);
        }

        System.out.println("\n--- TEST 4: seller insert ---");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departmentTest2);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
    }
}
