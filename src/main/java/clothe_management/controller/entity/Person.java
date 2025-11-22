package clothe_management.controller.entity;

abstract class Person {
    public enum Sex {
        MALE, FEMALE
    }

    protected String name;
    protected Sex sex;
    protected String phone;
    protected String address;

    public Person(String name, Sex sex, String phone, String address) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.address = address;
    }

    // Setters (chỉ các field có thể thay đổi)
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // sex thường không thay đổi → không dùng setter
    // Getters
    public String getName() {
        return name;
    }
    public Sex getSex() {
        return sex;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
}
