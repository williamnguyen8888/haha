package com.william.model;

public class Customer {
    private int customerID;
    private String username;
    private String password;
    private String firstname;
    private String surname;
    private String birthDay;
    private String phoneNumber;
    private String Address;
    private int TypeAccountId;


    public Customer() {
    }

    public Customer(int customerID, String username, String password, String firstname, String surname, String birthDay, String phoneNumber, String address) {
        this.customerID = customerID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.surname = surname;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        Address = address;
    }


    public int getTypeAccountId() {
        return TypeAccountId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setTypeAccountId(int typeAccountId) {
        TypeAccountId = typeAccountId;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
