package clothe_management.controller.entity;

public class Inventory {
    private final String productID;
    private int quantity;

    public Inventory(String productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getProductID() { 
        return productID; 
    }
    public int getQuantity() { 
        return quantity; 
    }
    public void setQuantity(int quantity) { 
        this.quantity = quantity;
    }
}
