package clothe_management.GUI;

import clothe_management.controller.service.dummyController;
import clothe_management.controller.entity.User;
import clothe_management.controller.enumVar.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.List;

public class HelloController {

    private dummyController controller = new dummyController();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onViewButtonClick() {
        List<User> user = controller.showUser();
        String userinfo = "";
        for (User u : user) {
            userinfo += u.toString() + "\n";
        }
            welcomeText.setText(userinfo);
    }

    @FXML
    protected void onInsertButtonClick() {
        User dummy = new User("Huy", Sex.MALE,"10988209","VGU");
        String message = controller.insertUser(dummy);
        welcomeText.setText(message);
    }

    @FXML
    protected void onDeleteButtonClick() {
        String message = controller.deleteUser("Huy");
        welcomeText.setText(message);
    }
}
