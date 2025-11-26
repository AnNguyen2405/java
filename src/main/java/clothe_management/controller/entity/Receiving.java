package clothe_management.controller.entity;

import java.sql.Timestamp;
import clothe_management.controller.enumVar.*;

public class Receiving {
    private final String receivingID;
    private final String supplierID;
    private final String employeeID;
    private Timestamp date;
    public Receiving(String receivingID, String supplierID, String employeeID, Timestamp date) {
        this.receivingID = receivingID;
        this.supplierID = supplierID;
        this.employeeID = employeeID;
        this.date = date;
    }
    public String getReceivingID() {
        return receivingID;
    }
    public String getSupplierID() {
        return supplierID;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }
}

