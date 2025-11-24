package clothe_management.controller.service;
import clothe_management.database.sample.dummyDAO;
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

    public String insertUser(User user)
    {
        String message = dummydao.insert(user);
        return message;
    }

    public String deleteUser(String id)
    {
        String message = dummydao.delete(id);
        return message;
    }
}
