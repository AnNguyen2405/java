package clothe_management.controller.service;

import clothe_management.controller.entity.Employee;
import java.util.List;

public interface EmployeeService {
    int addEmployee(Employee e);
    int updateEmployee(Employee e);
    int removeEmployee(String employeeID);
    Employee findEmployeeById(String employeeID);
    List<Employee> findEmployeeByName (String name);
    List<Employee> getAllEmployees();
    int calculateSalary(Employee employee);
}
