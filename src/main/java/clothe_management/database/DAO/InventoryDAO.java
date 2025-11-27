package clothe_management.database.DAO;

import clothe_management.controller.entity.Inventory;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;
import java.util.ArrayList;

public class InventoryDAO extends abstractGenericDAO<Inventory> {
    public Inventory findByID(String id){
        Inventory inventory = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT productID, stockAvailable, name, size FROM inventory i\n" +
                    "WHERE id = ?\n" +
                    "JOIN product p ON p.ID = i.productID;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_ID = resultSet.getString("productID");
                int current_stock = resultSet.getInt("stockAvailable");
                String current_name = resultSet.getString("name");
                String current_size = resultSet.getString("size");
                inventory = new Inventory(current_ID, current_name, Size.StringToEnum(current_size), current_stock);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return inventory;
    };

    public ArrayList<Inventory> findByName(String name){
        Connection connection = null;
        ArrayList<Inventory> inventory_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT productID, stockAvailable, name, size FROM inventory i\n" +
                    "WHERE name = ?\n" +
                    "JOIN product p ON p.ID = i.productID;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_ID = resultSet.getString("productID");
                int current_stock = resultSet.getInt("stockAvailable");
                String current_name = resultSet.getString("name");
                String current_size = resultSet.getString("size");
                Inventory inventory = new Inventory(current_ID, current_name, Size.StringToEnum(current_size), current_stock);
                inventory_list.add(inventory);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return inventory_list;
    };

    public ArrayList<Inventory> getAll(){
        ArrayList<Inventory> inventory_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT productID, stockAvailable, name, size FROM inventory i\n" +
                    "JOIN product p ON p.ID = i.productID;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_ID = resultSet.getString("productID");
                int current_stock = resultSet.getInt("stockAvailable");
                String current_name = resultSet.getString("name");
                String current_size = resultSet.getString("size");
                Inventory inventory = new Inventory(current_ID, current_name, Size.StringToEnum(current_size), current_stock);
                inventory_list.add(inventory);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return inventory_list;
    };

    public int insert(Inventory entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO inventory(productID, stockAvailable) " +
                    "VALUES (?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getProductID());
            preparedStatement.setInt(2, entity.getStockAvailable());
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

    public int update(Inventory entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE inventory SET stockAvailable = ? WHERE productID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, entity.getStockAvailable());
            preparedStatement.setString(2, entity.getProductID());
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
        Connection connection = null;
        int deletedRow = 0;
        String message = "0 row(s) deleted";
        try {
            String sql = "DELETE FROM inventory where productID = ?";
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
