package clothe_management.controller.entity;

import java.sql.Timestamp;
import clothe_management.controller.enumVar.*;

public class Receipt {

    private final String receiptID;
    private Timestamp date;
    private final String customerID;
    private final String employeeID;
    private int amount;
    private PaymentMethod paymentMethod;

    public Receipt(String receiptID, Timestamp date, String customerID, String employeeID, int amount, PaymentMethod paymentMethod) {
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
    public Timestamp getDate() {
        return date;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public int getAmount() {
        return amount;
    }
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    // Setters
    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


