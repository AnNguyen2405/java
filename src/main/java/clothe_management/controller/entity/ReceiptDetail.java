package clothe_management.controller.entity;

public class ReceiptDetail {
    private final String receiptID;
    private final String productID;
    private int quantity;
    private int unitSellPrice;
    private int unitCostPrice;

    public ReceiptDetail(String receiptID, String productID, int quantity, int unitSellPrice, int unitCostPrice) {
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
    public int getUnitSellPrice() {
        return unitSellPrice;
    }
    public int getUnitCostPrice() {
        return unitCostPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setUnitSellPrice(int unitSellPrice) {
        this.unitSellPrice = unitSellPrice;
    }
    public void setUnitCostPrice(int unitCostPrice) {
        this.unitCostPrice = unitCostPrice;
    }
}
