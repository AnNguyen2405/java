package clothe_management.database.DAO;

import clothe_management.controller.entity.Supplier;
import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;
import java.util.ArrayList;

public class SupplierDAO extends abstractGenericDAO<Supplier> implements singleKeyDAO<Supplier>{
    public Supplier findByID(String id){
        Supplier supplier = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM supplier WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_ID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_contactPerson = resultSet.getString("contactPerson");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                String current_email = resultSet.getString("email");
                supplier = new Supplier(current_ID, current_name, current_contactPerson,
                        current_phone, current_address, current_email);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return supplier;
    };

    public ArrayList<Supplier> getAll(){
        ArrayList<Supplier> supplier_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM supplier";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_ID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_contactPerson = resultSet.getString("contactPerson");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                String current_email = resultSet.getString("email");
                Supplier supplier = new Supplier(current_ID, current_name, current_contactPerson,
                        current_phone, current_address, current_email);
                supplier_list.add(supplier);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return supplier_list;
    };

    public int insert(Supplier entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO supplier(ID, companyName, contactPerson, phone, address, email) " +
                    "VALUES (?,?,?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getSupplierID());
            preparedStatement.setString(2, entity.getCompanyName());
            preparedStatement.setString(3, entity.getContactPerson());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setString(6, entity.getEmail());
            addedRow = preparedStatement.executeUpdate();
            message = Integer.toString(addedRow) + " row(s) added. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
        }
        return addedRow;
    };

    public int update(Supplier entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE supplier SET companyName = ?, contactPerson = ?, phone = ?, address = ?, " +
                    "email = WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getCompanyName());
            preparedStatement.setString(2, entity.getContactPerson());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getEmail());
            preparedStatement.setString(6, entity.getSupplierID());
            updatedRow = preparedStatement.executeUpdate();
            message = Integer.toString(updatedRow) + " row(s) updated. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return updatedRow;
    };

    public int delete(String id){
        int deletedRow = 0;
        String message = "0 rows deleted";
        try {
            String sql = "DELETE FROM supplier where ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            deletedRow = preparedStatement.executeUpdate();
            message = Integer.toString(deletedRow) + " row(s) deleted.";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        }catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return deletedRow;
    };
}
