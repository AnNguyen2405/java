package clothe_management.controller.entity;

class Customer extends Person {
    private final String customerID;
    private int points;

    public Customer(String customerID, String name, String sex, String phone, String address, int points) {
        super(name, sex, phone, address);
        this.customerID = customerID;
        this.points = points;
    }

    // Getters
    public String getCustomerID() { 
       return customerID; 
    }
    public int getPoints() {
        return points; 
    }
    // Setters
    public void setPoints(int points) { 
       this.points = points; 
    }
    // setCustomerID không nên có (ID không thay đổi)
}
