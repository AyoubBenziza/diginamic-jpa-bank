package fr.diginamic.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie extends Account {
    @Column(name = "endDate", columnDefinition = "DATE")
    private LocalDate endDate;

    @Column(name = "rate", columnDefinition = "DECIMAL(10, 2)")
    private double rate;

    public AssuranceVie(int number, double balance, LocalDate endDate, double rate,Bank bank) {
        super(number, balance,bank);
        this.endDate = endDate;
        this.rate = rate;
    }

    public AssuranceVie() {}

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
