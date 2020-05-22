package com.softserve.itacademy.model;

public class NameAddressPair {
    private final Person person;
    private String address;

    public NameAddressPair(Person person, String address) {
        this.person = person;
        this.address = address;
    }

    public Person getPerson() {
        return person;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
