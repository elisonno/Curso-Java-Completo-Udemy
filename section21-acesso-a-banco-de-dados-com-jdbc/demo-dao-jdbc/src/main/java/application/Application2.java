package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("--- TEST 1: department findById ---");
        System.out.print("Desired department id: ");
        int desiredDepartment = sc.nextInt();
        Department department = departmentDao.findById(desiredDepartment);
        System.out.println(department);

        System.out.println("\n--- TEST 2: department findAll ---");
        List<Department> departments = departmentDao.findAll();
        for (Department departmentTest2 : departments){
            System.out.println(departmentTest2);
        }

        System.out.println("\n--- TEST 3: department insert ---");
        System.out.println("New name department ");
        sc.nextLine();
        String name = sc.nextLine();
        department = new Department(null,name);
        departmentDao.insert(department);
        departments = departmentDao.findAll();
        for (Department departmentTest2 : departments){
            System.out.println(departmentTest2);
        }

        System.out.println("\n--- TEST 4: department update ---");
        System.out.print("Department id to be updated: ");
        desiredDepartment = sc.nextInt();
        department = departmentDao.findById(desiredDepartment);
        sc.nextLine();
        System.out.print("New Name: ");
        name = sc.nextLine();
        department.setName(name);
        departmentDao.update(department);
        departments = departmentDao.findAll();
        for (Department departmentTest2 : departments){
            System.out.println(departmentTest2);
        }

        System.out.println("\n--- TEST 5: department delete ---");
        System.out.print("Department id to be deleted: ");
        desiredDepartment = sc.nextInt();
        departmentDao.deleteById(desiredDepartment);
        departments = departmentDao.findAll();
        for (Department departmentTest2 : departments){
            System.out.println(departmentTest2);
        }

        sc.close();
    }
}
