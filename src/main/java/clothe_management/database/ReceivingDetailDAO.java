package clothe_management.database;

import clothe_management.controller.entity.ReceivingDetail;
import clothe_management.database.customException.DatabaseConnectionException;

import java.sql.*;
import java.util.ArrayList;

public class ReceivingDetailDAO extends abstractGenericDAO<ReceivingDetail> implements compositeKeyDAO<ReceivingDetail>{
    public ArrayList<ReceivingDetail> findByLeftID(String id){
        ArrayList<ReceivingDetail> receivingDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving_details WHERE receivingID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("receivingID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceivingDetail receivingDetail = new ReceivingDetail(current_receivingID,  current_productID,
                        current_quantity, current_cost);
                receivingDetail_list.add(receivingDetail);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receivingDetail_list;
    };

    public ArrayList<ReceivingDetail> findByProductID(String id){
        ArrayList<ReceivingDetail> receivingDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving_details WHERE productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("receivingID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceivingDetail receivingDetail = new ReceivingDetail(current_receivingID,  current_productID,
                        current_quantity, current_cost);
                receivingDetail_list.add(receivingDetail);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receivingDetail_list;
    };

    public ReceivingDetail findByKey(String id, String productId){
        ReceivingDetail receivingDetail = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving_details WHERE receivingID = ? AND productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("receivingID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_cost = resultSet.getInt("unit_cost_price");
                receivingDetail = new ReceivingDetail(current_receivingID,  current_productID,
                        current_quantity, current_cost);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receivingDetail;
    };

    public ArrayList<ReceivingDetail> getAll(){
        ArrayList<ReceivingDetail> receivingDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receiving_details";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receivingID = resultSet.getString("receivingID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceivingDetail receivingDetail = new ReceivingDetail(current_receivingID,  current_productID,
                        current_quantity, current_cost);
                receivingDetail_list.add(receivingDetail);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receivingDetail_list;
    };

    public int insert(ReceivingDetail entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO receiving_details(receivingID, productID, quantity, unit_cost_price) " +
                    "VALUES (?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getReceivingID());
            preparedStatement.setString(2, entity.getProductID());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setInt(4, entity.getUnitCostPrice());
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

    public int update(ReceivingDetail entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE receivingDetail SET quantity = ?, unit_cost_price = ?" +
                    "WHERE receivingID = ? AND productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getQuantity());
            preparedStatement.setInt(2, entity.getUnitCostPrice());
            preparedStatement.setString(3, entity.getReceivingID());
            preparedStatement.setString(4, entity.getProductID());
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

    public int deleteByLeftID(String id){
        int deletedRow = 0;
        String message = "0 row(s) deleted";
        try {
            String sql = "DELETE FROM receivingDetail where receivingID = ?";
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

    public int deleteByKey(String id, String productId){
        int deletedRow = 0;
        String message = "0 row(s) deleted";
        try {
            String sql = "DELETE FROM receivingDetail where receivingID = ? AND productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, productId);
            deletedRow = preparedStatement.executeUpdate();
            message = Integer.toString(deletedRow) + " row(s) deleted.";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return deletedRow;
    };
}
