package clothe_management.controller.entity;

class Employee extends Person {
    private final String employeeID;
    private int hours;
    private String role;
    private double salary;
    public Employee(String employeeID, String name, String sex, String phone, String address, int hours, String role, double salary) {
        super(name, sex, phone, address);
        this.employeeID = employeeID;
        this.hours = hours;
        this.role = role;
        this.salary = salary;
    }
    // SETTERS (only for fields that can change)
    public void setHours(int hours) { 
        this.hours = hours; 
    }
    public void setRole(String role) { 
        this.role = role; 
    }
    public void setSalary(double salary) { 
        this.salary = salary;
    }

    public String getEmployeeID() { 
      return employeeID; 
    }
    public int getHours() {
       return hours; 
    }
    public String getRole() {
       return role; 
    }
    public double getSalary() { 
       return salary; 
    }
}

