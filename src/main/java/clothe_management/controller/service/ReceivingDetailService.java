package clothe_management.controller.service;

import clothe_management.controller.entity.ReceivingDetail;
import java.util.List;

public interface ReceivingDetailService {
    int addDetail(ReceivingDetail d);
    int updateDetail(ReceivingDetail d);
    int removeDetail(String receivingID, String productID);
    ReceivingDetail findDetail(String receivingID, String productID);
    List<ReceivingDetail> getDetailsByReceiving(String receivingID);
    List<ReceivingDetail> getAllDetails();
    int calculateDetailCost(String receivingID, String productID);
    int calculateTotalCost(String receivingID);
}