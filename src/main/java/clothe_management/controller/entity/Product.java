package clothe_management.controller.entity;

import clothe_management.controller.enumVar.*;

public class Product {

    private final String productID;
    private String name;
    private String description;
    private Size size;
    private String color;
    private Category category;
    private int price;
    private final String supplierID;

    public Product(String productID, String name, String description, Size size, String color, Category category, int price, String supplierID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.category = category;
        this.price = price;
        this.supplierID = supplierID;
    }

    public String getProductID() {
        return productID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Size getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    public Category getCategory() {
        return category;
    }
    public int getPrice() {
        return price;
    }
    public String getSupplier() {
        return supplierID;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
