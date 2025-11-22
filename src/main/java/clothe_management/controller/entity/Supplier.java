package clothe_management.controller.entity;

public class Supplier {
    private final String supplierID;
    private String companyName;
    private String contactPerson;
    private String phone;
    private String address;
    private String email;

    public Supplier(String supplierID, String companyName, String contactPerson, String phone, String address, String email) {
        this.supplierID = supplierID;
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    // Getters
    public String getSupplierID() {
        return supplierID; 
    }
    public String getCompanyName() {
        return companyName; 
    }
    public String getContactPerson() { 
        return contactPerson; 
    }
    public String getPhone() { 
        return phone; 
    }
    public String getAddress() { 
        return address; 
    }
    public String getEmail() { 
        return email; 
    }

    // Setters
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
