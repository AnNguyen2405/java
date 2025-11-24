package clothe_management.controller.entity;

import clothe_management.controller.enumVar.*;

public class User extends Person {

    public User(String name, Sex sex, String phone, String address)
    {
        super(name,sex,phone,address);
    }

    public String toString() {
        return name + " " + sex + " " + phone + " " + address;
    }
}

