package clothe_management.database.sample;

public class user {
    private int id;
    private String username;
    private String email;

    // Constructor (to create User objects from database data)
    public user(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String getUser() {
        return username;
    }
}
