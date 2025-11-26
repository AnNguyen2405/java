package clothe_management.controller.service;

import clothe_management.database.dbConnection;

public class dbConnectionController {
    public void closeConnection()
    {
        dbConnection.closeConnection();
    }
}
