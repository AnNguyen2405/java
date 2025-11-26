package clothe_management.database;

import clothe_management.controller.entity.Receiving;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;

import java.sql.*;
import java.util.ArrayList;

public class ReceivingDAO extends abstractGenericDAO<Receiving> implements singleKeyDAO<Receiving>{
    public Receiving findByID(String id){
        Receiving receiving = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("ID");
                String current_supplierID = resultSet.getString("supplierID");
                String current_employeeID = resultSet.getString("employeeID");
                Timestamp current_date = resultSet.getTimestamp("date");
                receiving = new Receiving(current_receivingID,  current_supplierID,
                        current_employeeID, current_date);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiving;
    };

    public ArrayList<Receiving> getAll(){
        ArrayList<Receiving> receiving_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("ID");
                String current_supplierID = resultSet.getString("supplierID");
                String current_employeeID = resultSet.getString("employeeID");
                Timestamp current_date = resultSet.getTimestamp("date");
                Receiving receiving = new Receiving(current_receivingID,  current_supplierID,
                        current_employeeID, current_date);
                receiving_list.add(receiving);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiving_list;
    };

    public int insert(Receiving entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO receiving(ID, supplierID, employeeID,date) " +
                    "VALUES (?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getReceivingID());
            preparedStatement.setString(2, entity.getSupplierID());
            preparedStatement.setString(3, entity.getEmployeeID());
            preparedStatement.setTimestamp(4, entity.getDate());
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

    public int update(Receiving entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE receiving SET supplier = ?, employeeID = ?, date = ?" +
                    "WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getSupplierID());
            preparedStatement.setString(2, entity.getEmployeeID());
            preparedStatement.setTimestamp(3, entity.getDate());
            preparedStatement.setString(4, entity.getReceivingID());
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
        String message = "0 row(s) deleted";
        try {
            String sql = "DELETE FROM receiving where ID = ?";
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
