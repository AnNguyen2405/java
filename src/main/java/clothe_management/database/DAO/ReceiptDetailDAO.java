package clothe_management.database.DAO;

import clothe_management.controller.entity.ReceiptDetail;
import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;
import java.util.ArrayList;

public class ReceiptDetailDAO extends abstractGenericDAO<ReceiptDetail> implements compositeKeyDAO<ReceiptDetail>{
    public ArrayList<ReceiptDetail> findByLeftID(String id){
        ArrayList<ReceiptDetail> receiptDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receipt_details WHERE receivingID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("receiptID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_sell = resultSet.getInt("unit_sell_price");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceiptDetail receiptDetail = new ReceiptDetail(current_receiptID,  current_productID,
                        current_quantity, current_sell, current_cost);
                receiptDetail_list.add(receiptDetail);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiptDetail_list;
    };

    public ArrayList<ReceiptDetail> findByProductID(String id){
        ArrayList<ReceiptDetail> receiptDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receipt_details WHERE productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("receiptID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_sell = resultSet.getInt("unit_sell_price");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceiptDetail receiptDetail = new ReceiptDetail(current_receiptID,  current_productID,
                        current_quantity, current_sell, current_cost);
                receiptDetail_list.add(receiptDetail);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiptDetail_list;
    };

    public ReceiptDetail findByKey(String id, String productId){
        ReceiptDetail receiptDetail = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receipt_details WHERE receivingID = ? AND productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("receiptID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_sell = resultSet.getInt("unit_sell_price");
                int current_cost = resultSet.getInt("unit_cost_price");
                receiptDetail = new ReceiptDetail(current_receiptID,  current_productID,
                        current_quantity, current_sell, current_cost);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiptDetail;
    };

    public ArrayList<ReceiptDetail> getAll(){
        ArrayList<ReceiptDetail> receiptDetail_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM receipt_details";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_receiptID = resultSet.getString("receiptID");
                String current_productID = resultSet.getString("productID");
                int current_quantity = resultSet.getInt("quantity");
                int current_sell = resultSet.getInt("unit_sell_price");
                int current_cost = resultSet.getInt("unit_cost_price");
                ReceiptDetail receiptDetail = new ReceiptDetail(current_receiptID,  current_productID,
                        current_quantity, current_sell, current_cost);
                receiptDetail_list.add(receiptDetail);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return receiptDetail_list;
    };

    public int insert(ReceiptDetail entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO receipt_details(receiptD, productID, quantity, unit_sell_price, unit_cost_price) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getReceiptID());
            preparedStatement.setString(2, entity.getProductID());
            preparedStatement.setInt(3, entity.getQuantity());
            preparedStatement.setInt(4, entity.getUnitSellPrice());
            preparedStatement.setInt(5, entity.getUnitCostPrice());
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

    public int update(ReceiptDetail entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE receipt_details SET quantity = ?, unit_sell_price = ?, unit_cost_price = ?" +
                    "WHERE receiptID = ? AND productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getQuantity());
            preparedStatement.setInt(2, entity.getUnitSellPrice());
            preparedStatement.setInt(3, entity.getUnitCostPrice());
            preparedStatement.setString(4, entity.getReceiptID());
            preparedStatement.setString(5, entity.getProductID());
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
            String sql = "DELETE FROM receipt_details where receiptID = ?";
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
            String sql = "DELETE FROM receipt_details where receiptID = ? AND productID = ?";
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
