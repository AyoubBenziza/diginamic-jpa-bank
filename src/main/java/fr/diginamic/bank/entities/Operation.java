package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "operation")
public abstract class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Account account;

    public Operation(LocalDate date, double amount, String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public Operation() {}

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
