package clothe_management.controller.entity;

public class User extends Person {

    public User(String name, String sex, String phone, String address)
    {
        super(name,sex,phone,address);
    }

    public String toString() {
        return name + " " + sex + " " + phone + " " + address;
    }
}

