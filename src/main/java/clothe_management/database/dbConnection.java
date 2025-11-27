package clothe_management.database;

import clothe_management.database.customException.DatabaseConnectionException;
import java.sql.*;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/javademo_db";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static Connection connection;

    public static Connection connectDatabase()
    {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(connection);
                System.out.println("System database connected successfully!");
            } catch (SQLException e) {
                String message = "Error occured during connection.\nPlease check your credentials for: " + URL;
                throw new DatabaseConnectionException(message, e);
            }
        }
        return connection;
    }

    // close connection after operations
    public static void closeConnection()
    {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println(connection);
                System.out.println("System database connection closed successfully!");
            }
            catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }
}
