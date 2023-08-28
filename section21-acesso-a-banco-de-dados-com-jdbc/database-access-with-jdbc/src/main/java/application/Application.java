package application;

import database.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentID = ?)");

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows Affected: " + rowsAffected);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
