package clothe_management.controller.entity;

public class ReceivingDetail {
    private String receivingID;
    private String productID;
    private int quantity;
    private int unitCostPrice;
    public ReceivingDetail(String receivingID, String productID, int quantity, int unitCostPrice) {
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
    public int getUnitCostPrice() {
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
    public void setUnitCostPrice(int unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }
}

