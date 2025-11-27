package clothe_management.controller.service;

import clothe_management.controller.entity.Inventory;
import java.util.List;

public interface InventoryService {
    int addStock(String productID, String itemName, String itemSize, int quantity);
    boolean removeStock(String productID, int quantity); 
    int setStock(String productID, int newStock); 
    int checkStock(String productID); 
    Inventory findItem(String productID);
    List<Inventory> getAllItems();
    
}