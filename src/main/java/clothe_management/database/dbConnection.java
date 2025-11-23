package clothe_management.database;

import java.sql.*;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/javademo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection connectDatabase()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException e)
        {
            String message = "Error occured during connection.\nPlease check your credentials for: " + URL;
            throw new DatabaseConnectionException(message, e);
        }
        return connection;
    }

    public static void main(String[] args)
    {
        dbConnection test = new dbConnection();
        Connection test_connection = test.connectDatabase();
        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}
