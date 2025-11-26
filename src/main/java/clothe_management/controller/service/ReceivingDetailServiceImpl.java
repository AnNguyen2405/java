package clothe_management.controller.service;

import clothe_management.database.ReceivingDetailDAO;
import clothe_management.controller.entity.ReceivingDetail;
import java.util.List;

public class ReceivingDetailServiceImpl implements ReceivingDetailService {
    private ReceivingDetailDAO detailDAO = new ReceivingDetailDAO();

    @Override
    public int addDetail(ReceivingDetail d) {
        int row = detailDAO.insert(d);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateDetail(ReceivingDetail d) {
        int row = detailDAO.update(d);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int removeDetail(String receivingID, String productID) {
        int row = detailDAO.deleteByKey(receivingID, productID);  
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public ReceivingDetail findDetail(String receivingID, String productID) {
        return detailDAO.findByKey(receivingID, productID);
    }

    @Override
    public List<ReceivingDetail> getDetailsByReceiving(String receivingID) {
        return detailDAO.findByLeftID(receivingID);
    }
    
    @Override
    public List<ReceivingDetail> getAllDetails() {
        return detailDAO.getAll();
    }

    @Override
    public int calculateDetailCost(String receivingID, String productID) {
        ReceivingDetail d = detailDAO.findByKey(receivingID, productID);
        if (d != null) {
            return d.getQuantity() * d.getUnitCostPrice();
        } else {
            return 0;
        }
    }

    @Override
    public int calculateTotalCost(String receivingID) {
        List<ReceivingDetail> detailList = detailDAO.findByLeftID(receivingID);
        int total = 0;
        for (ReceivingDetail d : detailList) {
            total += d.getQuantity() * d.getUnitCostPrice();
        }
        return total;
    }
}

