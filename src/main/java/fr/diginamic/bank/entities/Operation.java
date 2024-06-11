package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Represents an operation on an account
 * It is an abstract class that holds common attributes and methods for all types of operations.
 * It is linked to the Account entity.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "operation")
public abstract class Operation {
    /**
     * The unique identifier of the operation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The date of the operation.
     */
    @Column(name = "date")
    private LocalDate date;

    /**
     * The amount of the operation.
     */
    @Column(name = "amount")
    private double amount;

    /**
     * The description of the operation.
     */
    @Column(name = "description")
    private String description;

    /**
     * The account that the operation is performed on.
     */
    @ManyToOne
    private Account account;

    /**
     * Constructor for creating a new Operation with specified date, amount, and description.
     * @param date The date of the operation.
     * @param amount The amount of the operation.
     * @param description The description of the operation.
     */
    public Operation(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    /**
     * Default constructor for creating a new Operation.
     */
    public Operation() {}

    /**
     * Setter for the date of the operation.
     * @param date The date of the operation.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for the date of the operation.
     * @return The date of the operation.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter for the amount of the operation.
     * @param amount The amount of the operation.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter for the amount of the operation.
     * @return The amount of the operation.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter for the description of the operation.
     * @param description The description of the operation.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the description of the operation.
     * @return The description of the operation.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the account that the operation is performed on.
     * @param account The account that the operation is performed on.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Getter for the account that the operation is performed on.
     * @return The account that the operation is performed on.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Setter for the unique identifier of the operation.
     * @param id The unique identifier of the operation.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the unique identifier of the operation.
     * @return The unique identifier of the operation.
     */
    public int getId() {
        return id;
    }
}
