package clothe_management.controller.service;

import clothe_management.controller.entity.Product;
import clothe_management.database.DAO.ProductDAO;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO = new ProductDAO();
    @Override
    public int addProduct(Product p) {
        if (productDAO.findByID(p.getProductID()) != null) {
            return -1; // Đã tồn tại
        }

        int row = productDAO.insert(p);
        if (row > 0) {
            return 1;  // Thành công
        } else {
            return 0;  // Thất bại
        }
    }

    @Override
    public int updateProduct(Product p) {
        if (productDAO.findByID(p.getProductID()) == null) {
            return -1; // Không tìm thấy
        }
        int row = productDAO.update(p);
        if (row > 0) {
            return 1;  // Thành công
        } else {
            return 0;  // Thất bại
        }
    }

    @Override
    public int removeProduct(String id) {
        int row = productDAO.delete(id);
        if (row > 0) {
            return 1;  // Thành công
        } else {

            return 0;  // Thất bại
        }
    }

    @Override
    public Product findProductById(String id) {
        return productDAO.findByID(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }
}