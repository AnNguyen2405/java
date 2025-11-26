package clothe_management.GUI;

import clothe_management.controller.service.dbConnectionController;

public class dbCleanup {
    static dbConnectionController controller = new dbConnectionController();

    public static void quit()
    {
        controller.closeConnection();
    }
}
