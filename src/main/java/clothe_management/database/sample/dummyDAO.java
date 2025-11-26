package clothe_management.database.sample;

import clothe_management.controller.entity.User;
import java.util.ArrayList;
import java.sql.*;

import clothe_management.controller.enumVar.*;
import clothe_management.database.customException.DatabaseConnectionException;
import clothe_management.database.dbConnection;

public class dummyDAO extends dummyAbstractDAO{
    dbConnection dbconnection;

    public dummyDAO()
    {
        dbconnection = new dbConnection();
    }

    public ArrayList<User> userRetrieve() {
        ArrayList<User> userlist = new ArrayList<User>();
        try {
            Sex sex_e = Sex.MALE;
            String sql = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data using column names or indices
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                try {
                    sex_e = Sex.valueOf(sex.toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.err.print("Invalid enum");
                }

                userlist.add(new User(name, sex_e, phone, address));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return userlist;
    }

    public String insert(User entity){
        String message = "0 rows affected.";
        try {
            String sql = "INSERT INTO user(name,sex,phone,address) " +
                    String.format("VALUES ('%s','%s','%s','%s')",entity.getName(), entity.getSex(),
                            entity.getPhone(), entity.getAddress()) ;

            // System.out.println(sql);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int addedRow = preparedStatement.executeUpdate();
            message = Integer.toString(addedRow) + " rows affected.";
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
            if (e.getErrorCode() == 1062)
            {
                message += "\nDuplicate key value detected. Please enter another value.";
            }
        } catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return message;
    };

    public String delete(String id){
        String message = "0 row deleted.";
        try {
            String sql = "DELETE FROM user where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            int deletedRow = preparedStatement.executeUpdate();
            message = Integer.toString(deletedRow) + " row(s) deleted.";
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }catch (DatabaseConnectionException e) {
            System.err.println("Database connection error!");
        }
        return message;
    };
}
