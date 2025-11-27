package clothe_management.database.DAO;

import clothe_management.controller.entity.Product;
import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;
import java.util.ArrayList;

public class ProductDAO extends abstractGenericDAO<Product> implements singleKeyDAO<Product>{
    public Product findByID(String id){
        Product product = null;
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM product WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_productID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_description = resultSet.getString("description");
                String current_size = resultSet.getString("size");
                String current_colour = resultSet.getString("colour");
                String current_category = resultSet.getString("category");
                int current_price = resultSet.getInt("price");
                String current_supplierID = resultSet.getString("address");
                product = new Product(current_productID, current_name, current_description,
                        Size.StringToEnum(current_size), current_colour,
                        Category.StringToEnum(current_category), current_price, current_supplierID);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return product;
    };

    public ArrayList<Product> findByName(String name){
        ArrayList<Product> product_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
        try {
            String sql = "SELECT * FROM product WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_productID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_description = resultSet.getString("description");
                String current_size = resultSet.getString("size");
                String current_colour = resultSet.getString("colour");
                String current_category = resultSet.getString("category");
                int current_price = resultSet.getInt("price");
                String current_supplierID = resultSet.getString("address");
                Product product = new Product(current_productID, current_name, current_description,
                        Size.StringToEnum(current_size), current_colour,
                        Category.StringToEnum(current_category), current_price, current_supplierID);
                product_list.add(product);
                rowCount++;
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        } catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return product_list;
    };

    public ArrayList<Product> getAll(){
        ArrayList<Product> product_list = new ArrayList<>();
        int rowCount = 0;
        String message = "0 row(s) have been found";
            try {
            String sql = "SELECT * FROM product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String current_productID = resultSet.getString("ID");
                String current_name = resultSet.getString("name");
                String current_description = resultSet.getString("description");
                String current_size = resultSet.getString("size");
                String current_colour = resultSet.getString("colour");
                String current_category = resultSet.getString("category");
                int current_price = resultSet.getInt("price");
                String current_supplierID = resultSet.getString("supplierID");
                Product product = new Product(current_productID, current_name, current_description,
                        Size.StringToEnum(current_size), current_colour,
                        Category.StringToEnum(current_category), current_price, current_supplierID);
                product_list.add(product);
            }
            message = Integer.toString(rowCount) + " row(s) have been found. ";
        }
        catch (SQLException e) {
            message += SQLExceptionHandler(e);
            System.err.println(message);
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return product_list;
    };

    public int insert(Product entity){
        int addedRow = 0;
        String message = "0 row(s) added. ";
        try {
            String sql = "INSERT INTO product(ID, name, description, size, colour, category, price, supplierID) " +
                    "VALUES (?,?,?,?,?,?,?,?)" ;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getProductID());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setString(4, entity.getSize().name());
            preparedStatement.setString(5, entity.getColor());
            preparedStatement.setString(6, entity.getCategory().name());
            preparedStatement.setInt(7, entity.getPrice());
            preparedStatement.setString(8, entity.getSupplier());
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

    public int update(Product entity){
        int updatedRow = 0;
        String message = "0 row(s) updated. ";
        try {
            String sql = "UPDATE product SET name = ?, description = ?, size = ?, colour = ?, " +
                    "category = ?, price = ?, supplierID = ? WHERE ID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setString(3, entity.getSize().name());
            preparedStatement.setString(4, entity.getColor());
            preparedStatement.setString(5, entity.getCategory().name());
            preparedStatement.setInt(6, entity.getPrice());
            preparedStatement.setString(7, entity.getSupplier());
            preparedStatement.setString(8, entity.getProductID());
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
            String sql = "DELETE FROM product where ID = ?";
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
