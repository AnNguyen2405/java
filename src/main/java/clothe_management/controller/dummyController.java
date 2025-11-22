package clothe_management.controller;
import clothe_management.database.dummyDAO;
import clothe_management.controller.entity.User;
import java.util.ArrayList;

public class dummyController {
    private dummyDAO dummydao;

    public dummyController(){
        dummydao = new dummyDAO();
    };

    public ArrayList<User> showUser()
    {
        ArrayList<User> user = new ArrayList<User>();
        user = dummydao.userRetrieve();
        return user;
    }
}
