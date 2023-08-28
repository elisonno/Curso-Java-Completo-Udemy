package application;

import database.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Application {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DB.getConnection();
          /*  preparedStatement = connection.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "Values "
                    + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, "Gerome Smith");
            preparedStatement.setString(2, "gerome@gmail.com");
            preparedStatement.setDate(3, new java.sql.Date(sdf.parse("22/07/1995").getTime()));
            preparedStatement.setDouble(4, 3500.0);
            preparedStatement.setInt(5, 2);*/

            preparedStatement = connection.prepareStatement(
                    "insert into department (Name) values ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    System.out.println("Done! Id = "+ id);
                }
            }
            else {
                System.out.println("No rows affected!");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }/*
        catch (ParseException e){
            e.printStackTrace();
        }*/
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
