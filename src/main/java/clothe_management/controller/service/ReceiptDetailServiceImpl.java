package clothe_management.controller.service;

import clothe_management.controller.entity.ReceiptDetail;
import clothe_management.database.DAO.ReceiptDetailDAO;
import java.util.List;
import java.util.ArrayList;

public class ReceiptDetailServiceImpl implements ReceiptDetailService {
    private ReceiptDetailDAO detailDAO = new ReceiptDetailDAO();

    @Override
    public List<ReceiptDetail> getDetailsByReceiptID(String receiptID) {
        return detailDAO.findByLeftID(receiptID);
    }
    
    @Override
    public List<ReceiptDetail> getAllDetails() {
        return detailDAO.getAll();
    }

    @Override
    public int calculateTotalProfit(List<ReceiptDetail> details) {
        int totalProfit = 0;
        if (details == null) {
            return 0;
        }
        for (ReceiptDetail detail : details) {
            int profit = (detail.getUnitSellPrice() - detail.getUnitCostPrice()) * detail.getQuantity();
            totalProfit += profit;
        }
        return totalProfit;
    }

    @Override
    public List<ReceiptDetail> findDetailByProductID(String productID) {
        return detailDAO.findByProductID(productID);
    }

    @Override
    public int addDetail(ReceiptDetail detail) {
        if (detailDAO.findByKey(detail.getReceiptID(), detail.getProductID()) != null) {
            return -1; 
        }
        int row = detailDAO.insert(detail);
        if (row > 0) {
            return 1; 
        } else {
            return 0; 
        }
    }

    @Override
    public int updateDetail(ReceiptDetail detail) {
        if (detailDAO.findByKey(detail.getReceiptID(), detail.getProductID()) == null) {
            return -1; 
        }
        int row = detailDAO.update(detail);
        if (row > 0) {
            return 1; 
        } else {
            return 0; 
        }
    }

    @Override
    public int removeDetail(String receiptID, String productID) {
        int row = detailDAO.deleteByKey(receiptID, productID);
        if (row > 0) {
            return 1; 
        } else {
            return 0; 
        }
    }

    @Override
    public int removeDetailsByReceiptID(String receiptID) {
        return detailDAO.deleteByLeftID(receiptID);
    }
}