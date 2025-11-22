package clothe_management.controller.entity;

public class Product {
    private final String productID;
    private String name;
    private String description;
    private String size;
    private String color;
    private String category;
    private double price;
    private String barcode;
    private final Supplier supplier;

    public Product(String productID, String name, String description, String size, String color, String category, double price, String barcode, Supplier supplier) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.category = category;
        this.price = price;
        this.barcode = barcode;
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
    public String getSize() { 
        return size;
    }
    public String getColor() { 
        return color; 
    }
    public String getCategory() { 
        return category; 
    }
    public double getPrice() { 
        return price; 
    }
    public String getBarcode() { 
        return barcode; 
    }
    public Supplier getSupplier() { 
        return supplier; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
    public void setSize(String size) { 
        this.size = size; 
    }
    public void setColor(String color) { 
        this.color = color; 
    }
    public void setCategory(String category) { 
        this.category = category; 
    }
    public void setPrice(double price) { 
        this.price = price; 
    }
    public void setBarcode(String barcode) { 
        this.barcode = barcode;
    }
}