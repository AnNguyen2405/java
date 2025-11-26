package clothe_management.controller.service;

import clothe_management.controller.entity.Customer;
import java.util.List;

public interface CustomerService {
    int addCustomer(Customer c);
    int updateCustomer(Customer c);
    int removeCustomer(String customerID);
    Customer findCustomerById(String id);
    List<Customer> findCustomerByName(String name);
    List<Customer> getAllCustomers();
    int addPoints(String customerID, int purchase);
}
