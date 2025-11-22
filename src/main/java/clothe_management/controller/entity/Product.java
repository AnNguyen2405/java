package clothe_management.controller.entity;

public class Product {
    public enum Size {
        NA, S, M, L, XL
    }
    public enum Category {
        MEN, WOMEN, UNISEX, KID
    }

    private final String productID;
    private String name;
    private String description;
    private Size size;
    private String color;
    private Category category;
    private int price;
    private final Supplier supplier;

    public Product(String productID, String name, String description, Size size, String color, Category category, int price, Supplier supplier) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.category = category;
        this.price = price;
        this.supplier = supplier;
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
    public Supplier getSupplier() {
        return supplier;
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
