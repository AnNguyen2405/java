package clothe_management.controller.service;

import clothe_management.controller.entity.Inventory;
import clothe_management.controller.enumVar.*;
import clothe_management.database.DAO.InventoryDAO;
import java.util.List;

public class InventoryServiceImpl implements InventoryService {
    private InventoryDAO inventoryDAO = new InventoryDAO();

    @Override
    public int addStock(String productID, String itemName, String itemSize, int quantity) {
        Inventory existingInventory = inventoryDAO.findByID(productID);
        if (existingInventory != null) {
            int newStock = existingInventory.getStockAvailable() + quantity;
            existingInventory.setStockAvailable(newStock);
            int rowsUpdated = inventoryDAO.update(existingInventory);
            if (rowsUpdated > 0) {
                return 1; 
            } else {
                return 0; 
            }
        } else {
            Size sizeEnum = Size.StringToEnum(itemSize);
            Inventory newInventory = new Inventory(productID, itemName, sizeEnum, quantity);
            int rowsInserted = inventoryDAO.insert(newInventory);
            if (rowsInserted > 0) {
                return 1; 
            } else {
                return 0; 
            }
        }
    }

    @Override
    public boolean removeStock(String productID, int quantity) {
        Inventory existingInventory = inventoryDAO.findByID(productID);
        if (existingInventory != null) {
            int currentStock = existingInventory.getStockAvailable();
            if (currentStock >= quantity) {
                int newStock = currentStock - quantity;
                existingInventory.setStockAvailable(newStock);
                int rowsUpdated = inventoryDAO.update(existingInventory);
                if (rowsUpdated > 0) {
                    return true; 
                } else {
                    return false; 
                }
            } else {
                return false;
            }
        } else {
            return false; 
        }
    }

    @Override
    public int setStock(String productID, int newStock) {
        Inventory existingInventory = inventoryDAO.findByID(productID);
        if (existingInventory != null) {
            existingInventory.setStockAvailable(newStock);
            int rowsUpdated = inventoryDAO.update(existingInventory);
            if (rowsUpdated > 0) {
                return 1; 
            } else {
                return 0; 
            }
        } else {
            return -1; 
        }
    }

    @Override
    public int checkStock(String productID) {
        Inventory existingInventory = inventoryDAO.findByID(productID);
        if (existingInventory != null) {
            return existingInventory.getStockAvailable(); 
        } else {
            return -1; 
        }
    }

    @Override
    public Inventory findItem(String productID) {
        return inventoryDAO.findByID(productID);
    }

    @Override
    public List<Inventory> getAllItems() {
        return inventoryDAO.getAll();
    }
}