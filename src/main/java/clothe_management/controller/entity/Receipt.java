package clothe_management.controller.entity;
import java.util.Date;

public class Receipt {
    private final String receiptID;
    private Date date;
    private final String customerID;
    private final String employeeID;
    private double amount;
    private String paymentMethod;

    public Receipt(String receiptID, Date date, String customerID, String employeeID, double amount, String paymentMethod) {
        this.receiptID = receiptID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    // Getters
    public String getReceiptID() { 
        return receiptID;
    }
    public Date getDate() { 
        return date; 
    }
    public String getCustomerID() { 
        return customerID; 
    }
    public String getEmployeeID() { 
        return employeeID; 
    }
    public double getAmount() { 
        return amount; 
    }
    public String getPaymentMethod() { 
        return paymentMethod; 
    }

    // Setters
    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) { 
        this.amount = amount; 
    }

    public void setPaymentMethod(String paymentMethod) { 
        this.paymentMethod = paymentMethod;
    }
}

