package clothe_management.controller.entity;

import clothe_management.controller.enumVar.*;

public class Inventory {
    private final String productID;
    private String itemName;
    private Size itemSize;
    private int stockAvailable;

    public Inventory(String productID, String itemName, Size itemSize, int stockAvailable) {
        this.productID = productID;
        this.itemName = itemName;
        this.itemSize = itemSize;
        this.stockAvailable = stockAvailable;
    }

    public String getProductID() {
        return productID;
    }

    public String getItemName() {
        return itemName;
    }

    public Size getItemSize() {
        return itemSize;
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemSize(Size itemSize) {
        this.itemSize = itemSize;
    }

    public void setStockAvailable(int stockAvailable) {
        this.stockAvailable = stockAvailable;
    }
}
