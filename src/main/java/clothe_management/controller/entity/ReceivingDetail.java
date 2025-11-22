package clothe_management.controller.entity;

public class ReceivingDetail {
    private String receivingID;
    private String productID;
    private int quantity;
    private double unitCostPrice;
    public ReceivingDetail(String receivingID, String productID, int quantity, double unitCostPrice) {
        this.receivingID = receivingID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitCostPrice = unitCostPrice;
    }
    public String getReceivingID() { 
        return receivingID; 
    }
    public String getProductID() { 
        return productID; 
    }
    public int getQuantity() { 
        return quantity; 
    }
    public double getUnitCostPrice() {
        return unitCostPrice; 
    }
    public void setReceivingID(String receivingID) {
        this.receivingID = receivingID;
    }
    public void setProductID(String productID) {
        this.productID = productID;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setUnitCostPrice(double unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }
}

