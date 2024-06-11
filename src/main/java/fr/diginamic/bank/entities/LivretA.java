package fr.diginamic.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * This class represents a LivretA entity in the bank system.
 * It is a concrete class that represents a Livret A account.
 * It is linked to the Account entity.
 */
@Entity
@Table(name = "livretA")
public class LivretA extends Account {
    /**
     * The interest rate of the Livret A account.
     */
    @Column(name = "rate", columnDefinition = "DECIMAL(10, 2)")
    private double rate;

    /**
     * Constructor for creating a new LivretA with specified number, balance, interest rate, and bank.
     * @param number The unique number of the account.
     * @param balance The initial balance of the account.
     * @param rate The interest rate of the Livret A account.
     * @param bank The bank that the account belongs to.
     */
    public LivretA(int number, double balance, double rate, Bank bank) {
        super(number, balance, bank);
        this.rate = rate;
    }

    /**
     * Default constructor for creating a new LivretA.
     */
    public LivretA() {}

    /**
     * Setter for the interest rate of the Livret A account.
     * @param rate The interest rate of the Livret A account.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Getter for the interest rate of the Livret A account.
     * @return The interest rate of the Livret A account.
     */
    public double getRate() {
        return rate;
    }
}
