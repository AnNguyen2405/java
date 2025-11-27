package clothe_management.controller.service;

import clothe_management.controller.entity.Supplier;
import clothe_management.database.DAO.SupplierDAO;

import java.util.List;
public class SupplierServiceImpl implements SupplierService {
    private SupplierDAO supplierDAO = new SupplierDAO();

    @Override
    public int addSupplier(Supplier s) {
        if (supplierDAO.findByID(s.getSupplierID()) != null) {
            return -1; // Đã tồn tại
        }

        int row = supplierDAO.insert(s);
        if (row > 0) {
            return 1;  // Thành công
        } else {
            return 0;  // Thất bại
        }
    }

    @Override
    public int updateSupplier(Supplier s) {
        if (supplierDAO.findByID(s.getSupplierID()) == null) {
            return -1; // Không tìm thấy
        }
        int row = supplierDAO.update(s);
        if (row > 0) {
            return 1;  // Thành công
        } else {
            return 0;  // Thất bại
        }
    }

    @Override
    public int removeSupplier(String id) {
        int row = supplierDAO.delete(id);
        if (row > 0) {
            return 1;  // Thành công
        } else {
            return 0;  // Thất bại
        }
    }

    @Override
    public Supplier findSupplierById(String id) {
        return supplierDAO.findByID(id);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAll();
    }
}