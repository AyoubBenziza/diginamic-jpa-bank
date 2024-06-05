package fr.diginamic.bank.entities;

import jakarta.persistence.*;

@Embeddable
public class Address {
    @Column(name = "number", columnDefinition = "INT UNSIGNED", nullable = false)
    private int number;

    @Column(name = "street", length = 255, nullable = false)
    private String street;

    @Column(name = "zipCode", length = 5, nullable = false)
    private String zipCode;

    @Column(name = "city", length = 255, nullable = false)
    private String city;

    public Address(int number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    public Address() {}

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

}
