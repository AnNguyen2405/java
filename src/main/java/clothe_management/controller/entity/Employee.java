package clothe_management.controller.entity;

import clothe_management.controller.enumVar.*;

class Employee extends Person {

    private final String employeeID;
    private int hours;
    private Role role;
    private int salary;
    public Employee(String employeeID, String name, Sex sex, String phone, String address, int hours, Role role, int salary) {
        super(name, sex, phone, address);
        this.employeeID = employeeID;
        this.hours = hours;
        this.role = role;
        this.salary = salary;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public int getHours() {
        return hours;
    }
    public Role getRole() {
        return role;
    }
    public int getSalary() {
        return salary;
    }
}

