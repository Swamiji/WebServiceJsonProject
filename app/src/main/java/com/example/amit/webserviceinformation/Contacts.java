package com.example.amit.webserviceinformation;

/**
 * Created by Amit on 7/11/2017.
 */

public class Contacts {
    private String name,email_id,mobile_number;

    public Contacts(String name, String email_id, String mobile_number) {
        this.setName(name);
        this.setEmail_id(email_id);
        this.setMobile_number(mobile_number);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}
