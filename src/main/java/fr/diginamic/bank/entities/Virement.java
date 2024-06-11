package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * Represents a virement operation
 * It is a subclass of Operation and holds the recipient of the virement.
 * It is linked to the Operation entity.
 * It is linked to the Account entity.
 */
@Entity
@Table(name = "virement")
public class Virement extends Operation {
    /**
     * The recipient of the virement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The recipient of the virement
     */
    @Column(name = "recipient")
    private String recipient;

    /**
     * Creates a new virement
     * @param recipient the recipient of the virement
     * @param date the date of the virement
     * @param amount the amount of the virement
     * @param description the description of the virement
     */
    public Virement(String recipient,LocalDate date, double amount, String description) {
        super(date, amount, description);
        this.recipient = recipient;
    }

    /**
     * Default constructor for creating a new Virement.
     */
    public Virement() {}

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

    /**
     * Setter for the recipient of the virement.
     * @param recipient The recipient of the virement.
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * Getter for the recipient of the virement.
     * @return The recipient of the virement.
     */
    public String getRecipient() {
        return recipient;
    }
}
