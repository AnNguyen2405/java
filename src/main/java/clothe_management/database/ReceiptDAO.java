package clothe_management.database;

import clothe_management.controller.entity.Receipt;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;

import java.sql.*;
import java.util.ArrayList;

public class ReceiptDAO extends abstractGenericDAO<Receipt>{
    public Receipt findByID(String id){
        Connection connection = null;
        Receipt receipt = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM receipt WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("ID");
                Timestamp current_date = resultSet.getTimestamp("date");
                String current_customer = resultSet.getString("customerID");
                String current_employeeID = resultSet.getString("employeeID");
                int current_totalAmount = resultSet.getInt("total_amount");
                String current_paymentMethod = resultSet.getString("payment_method");
                receipt = new Receipt(current_receiptID, current_date, current_customer,
                        current_employeeID, current_totalAmount,
                        PaymentMethod.StringToEnum(current_paymentMethod));
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return receipt;
    };

    public ArrayList<Receipt> getAll(){
        Connection connection = null;
        ArrayList<Receipt> receipt_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM receipt";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("ID");
                Timestamp current_date = resultSet.getTimestamp("date");
                String current_customer = resultSet.getString("customerID");
                String current_employeeID = resultSet.getString("employeeID");
                int current_totalAmount = resultSet.getInt("total_amount");
                String current_paymentMethod = resultSet.getString("payment_method");
                Receipt receipt = new Receipt(current_receiptID, current_date, current_customer,
                        current_employeeID, current_totalAmount,
                        PaymentMethod.StringToEnum(current_paymentMethod));
                receipt_list.add(receipt);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return receipt_list;
    };

    public int insert(Receipt entity){
        Connection connection = null;
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "INSERT INTO receipt(ID, date, customerID, employeeID, total_amount, payment_method) " +
                    "VALUES (?,?,?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getReceiptID());
            preparedStatement.setTimestamp(2, entity.getDate());
            preparedStatement.setString(3, entity.getCustomerID());
            preparedStatement.setString(4, entity.getEmployeeID());
            preparedStatement.setInt(5, entity.getAmount());
            preparedStatement.setString(6, entity.getPaymentMethod().name());
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
            closeConnection(connection);
        }
        return addedRow;
    };

    public int update(Receipt entity){
        Connection connection = null;
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "UPDATE receipt SET ID = ?, date = ?, customerID = ?, employeeID = ?, " +
                    "total_amount = ?, payment_method = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, entity.getDate());
            preparedStatement.setString(2, entity.getCustomerID());
            preparedStatement.setString(3, entity.getEmployeeID());
            preparedStatement.setInt(4, entity.getAmount());
            preparedStatement.setString(5, entity.getPaymentMethod().name());
            preparedStatement.setString(6, entity.getReceiptID());
            updatedRow = preparedStatement.executeUpdate();
            message = Integer.toString(updatedRow) + " row(s) updated. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        finally {
            closeConnection(connection);
        }
        return updatedRow;
    };

    public int delete(String id){
        Connection connection = null;
        int deletedRow = 0;
        String message = "0 rows deleted";
        try {
            connection = dbconnection.connectDatabase();
            String sql = "DELETE FROM receipt where ID = ?";
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
        finally {
            closeConnection(connection);
        }
        return deletedRow;
    };
}
