package clothe_management.GUI;

import clothe_management.controller.dummyController;
import clothe_management.controller.entity.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;

public class HelloController {

    private dummyController controller = new dummyController();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        List<User> user = controller.showUser();
        String userinfo = "";
        for (User u : user) {
            userinfo += u.toString() + "\n";
        }
            welcomeText.setText(userinfo);
    }
}
