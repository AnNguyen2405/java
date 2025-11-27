package clothe_management.controller.service;

import clothe_management.controller.entity.Employee;
import clothe_management.database.DAO.EmployeeDAO;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    public int addEmployee(Employee e) {
        if (employeeDAO.findByID(e.getEmployeeID()) != null) {
            return -1;
        }
        int row = employeeDAO.insert(e);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updateEmployee(Employee e) {
        if (employeeDAO.findByID(e.getEmployeeID()) == null) {
            return -1;
        }
        int row = employeeDAO.update(e);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int removeEmployee(String id) {
        int row = employeeDAO.delete(id);
        if (row > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeDAO.findByID(id);
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return employeeDAO.findByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAll();
    }

    @Override
    public int calculateSalary(Employee e) {
        int baseSalary = e.getHours() * e.getSalary();
        double bonus;
        switch (e.getRole()) {
            case MANAGER:
                bonus = 1.3;
                break;
            case CASHIER:
                bonus = 1.1;
                break;
            case INVENTORY_STAFF:
                bonus = 1.2;
                break;
            default:
                bonus = 1.0;
        }
        return (int)(baseSalary * bonus);
    }
}