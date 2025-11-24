package clothe_management.database;

import java.sql.*;

public abstract class abstractGenericDAO<T> implements genericDAO<T> {
    dbConnection dbconnection = new dbConnection();

    // helper methods
    // close connection after operations
    void closeConnection(Connection connection)
    {
        if (connection != null) {
            try {
                connection.close();
            }
            catch (SQLException e){
                System.err.println(e.getMessage());
            }
        }
    }

    // handle exception except database connection
    String SQLExceptionHandler(SQLException e)
    {
        System.err.println(e.getMessage());
        int code = e.getErrorCode();
        switch(code){
            case 1048:
                return "1 or more column(s) cannot be null get the null value(s).";
            case 1406:
                return "1 or more column(s) have exceeded the character limit.";
            case 1062:
                return "Product with the entered ID has existed.";
            case 1452:
                return "1 or more referencing column value(s) does not exist.";
            case 1451:
                return "1 or more row(s) is being referenced by other value.";
            default:
                return "An error occured";
        }
    }
}