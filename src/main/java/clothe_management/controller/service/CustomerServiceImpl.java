package clothe_management.controller.service;

import clothe_management.controller.entity.Customer;
import clothe_management.database.DAO.CustomerDAO;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();
    @Override
    public int addCustomer(Customer c) {
        // Check if ID exists first (optional, but good practice)
        if (customerDAO.findByID(c.getCustomerID()) != null) {
            return -1; // exists
        }
        
        int row = customerDAO.insert(c);
        if (row > 0) {
            return 1;   // success
        } else {
            return 0;   // fail
        }
    }

    @Override
    public int updateCustomer(Customer c) {
        if (customerDAO.findByID(c.getCustomerID()) == null) {
            return -1;  // not found
        }
        int row = customerDAO.update(c);
        if (row > 0) {
            return 1;   // success
        } else {
            return 0;   // fail
        }
    }

    @Override
    public int removeCustomer(String id) {
        int row = customerDAO.delete(id);
        if (row > 0) {
            return 1;   // success
        } else {
            return 0;   // fail
        }
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDAO.findByID(id);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerDAO.findByName(name);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.getAll();
    }

    @Override
    public int addPoints(String customerID, int purchase) {
        Customer c = customerDAO.findByID(customerID);
        if (c == null) {
            return -1;  // customer not found
        }
        int points = purchase / 10000; // earn 1 point per 10,000 VND
        c.setPoints(c.getPoints() + points);
        
        int row = customerDAO.update(c);
        if (row > 0) {
            return 1;   // success
        } else {
            return 0; //fail
        }
    }
}




