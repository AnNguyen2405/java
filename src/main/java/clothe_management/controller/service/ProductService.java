package clothe_management.controller.service;

import clothe_management.controller.entity.Product;
import java.util.List;

public interface ProductService {
    int addProduct(Product p);
    int updateProduct(Product p);
    int removeProduct(String productID);
    Product findProductById(String id);
    List<Product> findProductByName(String name);
    List<Product> getAllProducts();
}