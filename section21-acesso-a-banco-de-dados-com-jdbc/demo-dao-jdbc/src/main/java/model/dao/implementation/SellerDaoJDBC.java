package model.dao.implementation;

import database.DB;
import database.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE seller.Id = ? ");

            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Department currentDepartment = new Department();
                currentDepartment.setId(resultSet.getInt("DepartmentId"));
                currentDepartment.setName(resultSet.getString("DepName"));
                Seller currentSeller = new Seller();
                currentSeller.setId(resultSet.getInt("Id"));
                currentSeller.setName(resultSet.getString("Name"));
                currentSeller.setEmail(resultSet.getString("Email"));
                currentSeller.setBirthDate(resultSet.getDate("BirthDate"));
                currentSeller.setBaseSalary(resultSet.getDouble("BaseSalary"));
                currentSeller.setDepartment(currentDepartment);
                return currentSeller;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(statement);
            DB.closeResulSet(resultSet);
        }


    }

    @Override
    public List<Seller> findAll() {
        return null;
    }
}
