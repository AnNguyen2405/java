package clothe_management.database.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class userDAO {
    // Re-use your connection details (ideally from a separate config class)
    private static final String URL = "jdbc:mysql://localhost:3306/javademo_db";
    private static final String USER = "root";
    private static final String PASSWORD = "@N189pdp";

    // 🔑 Method to add a new user to the database
    public void addUser(String username, String email) {
        // SQL Injection-safe placeholder query
        String INSERT_USER_SQL = "INSERT INTO users (username, email) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {

            // Set the values for the placeholders (?)
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);

            // Execute the update (INSERT, UPDATE, DELETE)
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted user: " + username + ", Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
    }
}
