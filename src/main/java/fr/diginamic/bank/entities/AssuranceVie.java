package fr.diginamic.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

/**
 * This class represents an AssuranceVie entity in the bank system.
 * It is a concrete class that represents a life insurance account.
 * It is linked to the Account entity.
 */
@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Account {
    /**
     * The end date of the life insurance account.
     */
    @Column(name = "endDate", columnDefinition = "DATE")
    private LocalDate endDate;

    /**
     * The interest rate of the life insurance account.
     */
    @Column(name = "rate", columnDefinition = "DECIMAL(10, 2)")
    private double rate;

    /**
     * Constructor for creating a new AssuranceVie with specified number, balance, end date, interest rate, and bank.
     * @param number The unique number of the account.
     * @param balance The initial balance of the account.
     * @param endDate The end date of the life insurance account.
     * @param rate The interest rate of the life insurance account.
     * @param bank The bank that the account belongs to.
     */
    public AssuranceVie(int number, double balance, LocalDate endDate, double rate,Bank bank) {
        super(number, balance,bank);
        this.endDate = endDate;
        this.rate = rate;
    }

    /**
     * Default constructor for creating a new AssuranceVie.
     */
    public AssuranceVie() {}

    /**
     * Set the end date of the life insurance account.
     * @param endDate The end date of the life insurance account.
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Get the end date of the life insurance account.
     * @return The end date of the life insurance account.
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Set the interest rate of the life insurance account.
     * @param rate The interest rate of the life insurance account.
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Get the interest rate of the life insurance account.
     * @return The interest rate of the life insurance account.
     */
    public double getRate() {
        return rate;
    }
}
