package clothe_management.controller.service;

import clothe_management.controller.entity.Receipt;
import clothe_management.controller.entity.ReceiptDetail;
import java.util.List;

public interface ReceiptService {
    int createReceipt(Receipt receipt, List<ReceiptDetail> details);
    int calculateReceiptTotal(List<ReceiptDetail> details);
    int calculateReceiptProfit(String receiptID);
    Receipt findReceiptById(String id);
    List<Receipt> getAllReceipts();
}

