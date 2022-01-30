package com.namdroid.namserverspring.model;

public class UserProfile {
    private String id;
    private String name;
    private String phone;
    private String address;
    private String valid;

    public UserProfile(){}

    // alt+insert : spring tool 소스코드 generator
    public UserProfile(String id, String name, String phone, String address, String valid) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.valid = valid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
