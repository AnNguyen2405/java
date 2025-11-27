package clothe_management.controller.service;

import clothe_management.controller.entity.Receipt;
import clothe_management.controller.entity.ReceiptDetail;
import clothe_management.database.DAO.ReceiptDAO;
import clothe_management.database.DAO.ReceiptDetailDAO;
import clothe_management.database.DAO.ProductDAO;

import java.util.List;

public class ReceiptServiceImpl implements ReceiptService {
    private ReceiptDAO receiptDAO = new ReceiptDAO();
    private ReceiptDetailDAO receiptDetailDAO = new ReceiptDetailDAO(); 
    private ProductDAO productDAO = new ProductDAO(); 

    @Override
    public int createReceipt(Receipt receipt, List<ReceiptDetail> details) {
        if (receiptDAO.findByID(receipt.getReceiptID()) != null) {
            return -1; 
        }

        int receiptRows = receiptDAO.insert(receipt);
        if (receiptRows > 0) {
            boolean allDetailsInserted = true;
            for (ReceiptDetail detail : details) {
                int detailRows = receiptDetailDAO.insert(detail); 
                if (detailRows <= 0) {
                    allDetailsInserted = false;
                    break;
                }
            }
            if (allDetailsInserted) {
                return 1; 
            } else {
                return 0; 
            }
        } else {
            return 0; 
        }
    }

    @Override
    public int calculateReceiptTotal(List<ReceiptDetail> details) {
        int total = 0;
        for (ReceiptDetail detail : details) {
            int itemTotal = detail.getUnitSellPrice() * detail.getQuantity();
            total += itemTotal;
        }
        
        return total;
    }

    @Override
    public int calculateReceiptProfit(String receiptID) {
        Receipt receipt = receiptDAO.findByID(receiptID);
        if (receipt == null) {
            return -1; 
        }
        List<ReceiptDetail> details = receiptDetailDAO.findByLeftID(receiptID);
        int totalRevenue = 0;
        int totalCost = 0;
        for (ReceiptDetail detail : details) {
            int itemRevenue = detail.getUnitSellPrice() * detail.getQuantity();
            totalRevenue += itemRevenue;
            int productCost = productDAO.findByID(detail.getProductID()).getPrice();
            int itemCost = productCost * detail.getQuantity();
            totalCost += itemCost;
        }
        int profit = totalRevenue - totalCost;
        return profit;
    }

    @Override
    public Receipt findReceiptById(String id) {
        return receiptDAO.findByID(id);
    }

    @Override
    public List<Receipt> getAllReceipts() {
        return receiptDAO.getAll();
    }
}