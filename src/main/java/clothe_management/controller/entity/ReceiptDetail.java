package clothe_management.controller.entity;

public class ReceiptDetail {
    private final String receiptID;
    private final String productID;
    private int quantity;
    private double unitSellPrice;
    private double unitCostPrice;

    public ReceiptDetail(String receiptID, String productID, int quantity, double unitSellPrice, double unitCostPrice) {
        this.receiptID = receiptID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitSellPrice = unitSellPrice;
        this.unitCostPrice = unitCostPrice;
    }
    public String getReceiptID() {
        return receiptID; 
    }
    public String getProductID() { 
        return productID; 
    }
    public int getQuantity() { 
        return quantity; 
    }
    public double getUnitSellPrice() { 
        return unitSellPrice; 
    }
    public double getUnitCostPrice() { 
        return unitCostPrice; 
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setUnitSellPrice(double unitSellPrice) {
        this.unitSellPrice = unitSellPrice;
    }
    public void setUnitCostPrice(double unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }
}