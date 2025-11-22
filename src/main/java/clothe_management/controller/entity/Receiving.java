package clothe_management.controller.entity;
import java.util.Date;

public class Receiving {
    private final String receivingID;
    private final String supplierID;
    private final String employeeID;
    private Date date;
    public Receiving(String receivingID, String supplierID, String employeeID, Date date) {
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
    public Date getDate() { 
        return date; 
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
