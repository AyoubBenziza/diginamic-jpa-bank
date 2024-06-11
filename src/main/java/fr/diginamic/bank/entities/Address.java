package fr.diginamic.bank.entities;

import jakarta.persistence.*;

/**
 * This class represents an Address entity in the bank system.
 * It is an embeddable class that holds the address of a client.
 * It is linked to the Client entity.
 */
@Embeddable
public class Address {
    /**
     * The number of the address.
     */
    @Column(name = "number", columnDefinition = "INT UNSIGNED", nullable = false)
    private int number;

    /**
     * The street of the address.
     */
    @Column(name = "street", length = 255, nullable = false)
    private String street;

    /**
     * The zip code of the address.
     */
    @Column(name = "zipCode", length = 5, nullable = false)
    private String zipCode;

    /**
     * The city of the address.
     */
    @Column(name = "city", length = 255, nullable = false)
    private String city;

    /**
     * Constructor for creating a new Address with specified number, street, zip code, and city.
     * @param number The number of the address.
     * @param street The street of the address.
     * @param zipCode The zip code of the address.
     * @param city The city of the address.
     */
    public Address(int number, String street, String zipCode, String city) {
        this.number = number;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     * Default constructor for creating a new Address.
     */
    public Address() {}

    /**
     * Set the number of the address.
     * @param number The number of the address.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Get the number of the address.
     * @return The number of the address.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Set the street of the address.
     * @param street The street of the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the street of the address.
     * @return The street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the zip code of the address.
     * @param zipCode The zip code of the address.
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Get the zip code of the address.
     * @return The zip code of the address.
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Set the city of the address.
     * @param city The city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the city of the address.
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

}
