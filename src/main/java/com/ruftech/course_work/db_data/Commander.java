package com.ruftech.course_work.db_data;

public class Commander {
    private int personalNumber;
    private String lastname, firstname, address, phone;
    private double flyingHours;

    public Commander(int personalNumber, String lastname, String firstname, String address, String phone, double flyingHours) {
        this.personalNumber = personalNumber;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.phone = phone;
        this.flyingHours = flyingHours;
    }

    public int getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(int personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getFlyingHours() {
        return flyingHours;
    }

    public void setFlyingHours(double flyingHours) {
        this.flyingHours = flyingHours;
    }
}
