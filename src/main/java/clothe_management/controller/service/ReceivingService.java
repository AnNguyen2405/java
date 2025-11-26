package clothe_management.controller.service;

import clothe_management.controller.entity.Receiving;
import java.util.List;

public interface ReceivingService {
    int addReceiving(Receiving r);
    int updateReceiving(Receiving r);
    int removeReceiving(String receivingID);
    Receiving findReceivingById(String receivingID);
    List<Receiving> getAllReceivings();
    int calculateTotalCost(String receivingID);  // total cost of a single receiving
}

