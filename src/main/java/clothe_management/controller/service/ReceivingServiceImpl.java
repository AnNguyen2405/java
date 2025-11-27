package clothe_management.controller.service;

import clothe_management.controller.entity.Receiving;
import clothe_management.controller.entity.ReceivingDetail;
import clothe_management.database.DAO.ReceivingDAO;
import clothe_management.database.DAO.ReceivingDetailDAO;
import java.util.List;

public class ReceivingServiceImpl implements ReceivingService {
    private ReceivingDAO receivingDAO = new ReceivingDAO();
    private ReceivingDetailDAO detailDAO = new ReceivingDetailDAO();

    @Override
    public int addReceiving(Receiving r) {
        if (receivingDAO.findByID(r.getReceivingID()) != null) {
            return -1;
        } else {
            int row = receivingDAO.insert(r);
            if (row > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int updateReceiving(Receiving r) {
        if (receivingDAO.findByID(r.getReceivingID()) == null) {
            return -1;
        } else {
            int row = receivingDAO.update(r);
            if (row > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int removeReceiving(String receivingID) {
        int row = receivingDAO.delete(receivingID);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Receiving findReceivingById(String receivingID) {
        return receivingDAO.findByID(receivingID);
    }

    @Override
    public List<Receiving> getAllReceivings() {
        return receivingDAO.getAll();
    }

    @Override
    public int calculateTotalCost(String receivingID) {
        List<ReceivingDetail> list = detailDAO.findByLeftID(receivingID);
        int total = 0;
        for (ReceivingDetail d : list) {
            total += d.getQuantity() * d.getUnitCostPrice();
        }

        return total;
    }
}

