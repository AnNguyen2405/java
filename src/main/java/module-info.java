module clothe_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires clothe_management;

    opens clothe_management to javafx.fxml;
    exports clothe_management.GUI;
    opens clothe_management.GUI to javafx.fxml;
}