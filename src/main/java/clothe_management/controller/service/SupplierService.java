package clothe_management.controller.service;

import clothe_management.controller.entity.Supplier;
import java.util.List;

public interface SupplierService {
    int addSupplier(Supplier s);
    int updateSupplier(Supplier s);
    int removeSupplier(String supplierID);
    Supplier findSupplierById(String id); 
    List<Supplier> getAllSuppliers();
}