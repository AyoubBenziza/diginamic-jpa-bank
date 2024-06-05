package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "virement")
public class Virement extends Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "recipient")
    private String recipient;

    public Virement(String recipient,LocalDate date, double amount, String description) {
        super(date, amount, description);
        this.recipient = recipient;
    }

    public Virement() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }
}
