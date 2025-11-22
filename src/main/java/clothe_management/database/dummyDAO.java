package clothe_management.database;

import clothe_management.controller.entity.User;
import java.util.ArrayList;
import java.sql.*;

public class dummyDAO {
    dbConnection dbconnection;

    public dummyDAO()
    {
        dbconnection = new dbConnection();
    }

    public ArrayList<User> userRetrieve() {
        Connection connection = null;
        ArrayList<User> userlist = new ArrayList<User>();
        try {
            connection = dbconnection.connectDatabase();
            String sql = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve data using column names or indices
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                userlist.add(new User(name,sex,phone,address));
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
//        }
//        finally {
//            connection.close();
        }
        return userlist;
    }
}
