package clothe_management.controller.entity;

import clothe_management.controller.enumVar.*;

class Customer extends Person {
    private final String customerID;
    private int points;

    public Customer(String customerID, String name, Sex sex, String phone, String address, int points) {
        super(name, sex, phone, address);
        this.customerID = customerID;
        this.points = points;
    }
    public String getCustomerID() {
        return customerID;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}

