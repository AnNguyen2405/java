package clothe_management.database.DAO;

import clothe_management.controller.entity.Customer;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO extends abstractGenericDAO<Customer> implements singleKeyDAO<Customer>{
    public Customer findByID(String id){
        Customer customer = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM customer WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String current_customerID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_point = resultSet.getInt("point");
                customer = new Customer(current_customerID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_point);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return customer;
    };

    public ArrayList<Customer> findByName(String name){
        ArrayList<Customer> customer_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM customer WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_customerID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_point = resultSet.getInt("point");
                Customer customer = new Customer(current_customerID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_point);
                customer_list.add(customer);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return customer_list;
    };

    public ArrayList<Customer> getAll(){
        ArrayList<Customer> customer_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM Product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_customerID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_sex = resultSet.getString("sex");
                String current_phone = resultSet.getString("phone");
                String current_address = resultSet.getString("address");
                int current_point = resultSet.getInt("point");
                Customer customer = new Customer(current_customerID, current_name, Sex.StringToEnum(current_sex),
                        current_phone, current_address, current_point);
                customer_list.add(customer);
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
        return customer_list;
    };

    public int insert(Customer entity){
        String message = "0 row(s) added. ";
        int addedRow = 0;
        try {
            String sql = "INSERT INTO customer(ID, name, sex, phone, address, points) " +
                    "VALUES (?,?,?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getCustomerID());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSex().name());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setString(5, entity.getAddress());
            preparedStatement.setInt(6, entity.getPoints());
            addedRow = preparedStatement.executeUpdate();
            message = Integer.toString(addedRow) + " row(s) added. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return addedRow;
    };

    public int update(Customer entity){
        String message = "0 row(s) updated";
        int updatedRow = 0;
        try {
            String sql = "UPDATE customer SET name = ?, sex = ?, phone = ?, address = ?, " +
                    "points = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSex().name());
            preparedStatement.setString(3, entity.getPhone());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setInt(5, entity.getPoints());
            preparedStatement.setString(6, entity.getCustomerID());
            updatedRow = preparedStatement.executeUpdate();
            message = Integer.toString(updatedRow) + " row(s) updated.";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return updatedRow;
    };

    public int updatePoint(Customer entity, int point){
        String message = "0 row(s) updated";
        int updatedRow = 0;
        try {
            String sql = "UPDATE customer SET points = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, point);
            preparedStatement.setString(2, entity.getCustomerID());
            updatedRow = preparedStatement.executeUpdate();
            message = Integer.toString(updatedRow) + " row(s) updated.";
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
        String message = "0 rows affected";
        int deletedRow = 0;
        try {
            String sql = "DELETE FROM customer where ID = ?";
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
