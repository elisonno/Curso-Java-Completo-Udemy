package model.dao.implementation;

import database.DB;
import database.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection connection;

    public SellerDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Seller seller) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, seller.getName());
            statement.setString(2, seller.getEmail());
            statement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            statement.setDouble(4, seller.getBaseSalary());
            statement.setInt(5, seller.getDepartment().getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    seller.setId(id);
                }
                DB.closeResulSet(resultSet);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void update(Seller seller) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "UPDATE seller "
                            + "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? "
                            + "WHERE Id = ?");

            statement.setString(1, seller.getName());
            statement.setString(2, seller.getEmail());
            statement.setDate(3, new java.sql.Date(seller.getBirthDate().getTime()));
            statement.setDouble(4, seller.getBaseSalary());
            statement.setInt(5, seller.getDepartment().getId());
            statement.setInt(6, seller.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("DELETE FROM seller WHERE Id = ?");
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
        }
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
            if (resultSet.next()) {
                Department currentDepartment = instantiateDepartment(resultSet);
                Seller currentSeller = instantiateSeller(resultSet, currentDepartment);
                return currentSeller;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResulSet(resultSet);
        }
    }

    private Seller instantiateSeller(ResultSet resultSet, Department currentDepartment) throws SQLException {
        Seller currentSeller = new Seller();
        currentSeller.setId(resultSet.getInt("Id"));
        currentSeller.setName(resultSet.getString("Name"));
        currentSeller.setEmail(resultSet.getString("Email"));
        currentSeller.setBirthDate(resultSet.getDate("BirthDate"));
        currentSeller.setBaseSalary(resultSet.getDouble("BaseSalary"));
        currentSeller.setDepartment(currentDepartment);
        return currentSeller;
    }

    private Department instantiateDepartment(ResultSet resultSet) throws SQLException {
        Department currentDepartment = new Department();
        currentDepartment.setId(resultSet.getInt("DepartmentId"));
        currentDepartment.setName(resultSet.getString("DepName"));
        return currentDepartment;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "ORDER BY Name");

            resultSet = statement.executeQuery();

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> mapIdDepartment = new HashMap<>();
            while (resultSet.next()) {
                Department currentDepartment = mapIdDepartment.get(resultSet.getInt("DepartmentId"));
                if (currentDepartment == null) {
                    currentDepartment = instantiateDepartment(resultSet);
                    mapIdDepartment.put(currentDepartment.getId(), currentDepartment);
                }
                Seller currentSeller = instantiateSeller(resultSet, currentDepartment);
                sellers.add(currentSeller);
            }
            return sellers;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResulSet(resultSet);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT seller.*,department.Name as DepName "
                            + "FROM seller INNER JOIN department "
                            + "ON seller.DepartmentId = department.Id "
                            + "WHERE DepartmentId = ? "
                            + "ORDER BY Name");

            statement.setInt(1, department.getId());
            resultSet = statement.executeQuery();

            List<Seller> sellers = new ArrayList<>();
            Map<Integer, Department> mapIdDepartment = new HashMap<>();
            while (resultSet.next()) {
                Department currentDepartment = mapIdDepartment.get(resultSet.getInt("DepartmentId"));
                if (currentDepartment == null) {
                    currentDepartment = instantiateDepartment(resultSet);
                    mapIdDepartment.put(currentDepartment.getId(), currentDepartment);
                }
                Seller currentSeller = instantiateSeller(resultSet, currentDepartment);
                sellers.add(currentSeller);
            }
            return sellers;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(statement);
            DB.closeResulSet(resultSet);
        }
    }
}
