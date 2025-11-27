package clothe_management.controller.service;

import clothe_management.controller.entity.ReceiptDetail;
import java.util.List;

public interface ReceiptDetailService {
    List<ReceiptDetail> getDetailsByReceiptID(String receiptID);
    List<ReceiptDetail> getAllDetails(); 
    int calculateTotalProfit(List<ReceiptDetail> details);
    List<ReceiptDetail> findDetailByProductID(String productID); 
    int addDetail(ReceiptDetail detail);
    int updateDetail(ReceiptDetail detail);
    int removeDetail(String receiptID, String productID);
    int removeDetailsByReceiptID(String receiptID);
}