package clothe_management.database;

import java.sql.*;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/javademo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "@N189pdp";

    public Connection connectDatabase() throws SQLException
    {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        return connection;
    }

    public static void main(String[] args)
    {
        dbConnection dbc = new dbConnection();
        Connection connection = null;
        try {
            connection = dbc.connectDatabase();
        }
        catch (SQLException e)
        {
            System.out.println("Error connecting database");
        }
        System.out.print(connection);
    }
}
