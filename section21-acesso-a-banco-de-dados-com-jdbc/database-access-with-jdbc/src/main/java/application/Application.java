package application;

import database.DB;
import database.DbIntegretyException;

import java.sql.*;

public class Application {
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DB.getConnection();
            preparedStatement = connection.prepareStatement(
                    "DELETE FROM department "
                    + "where "
                    + "Id = ?");

            preparedStatement.setInt(1, 6);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Done! Rows Affected: " + rowsAffected);
        }
        catch (SQLException e){
            throw new DbIntegretyException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
