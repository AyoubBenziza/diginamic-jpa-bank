package fr.diginamic.bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "livretA")
public class LivretA extends Account {
    @Column(name = "rate", columnDefinition = "DECIMAL(10, 2)")
    private double rate;

    public LivretA(int number, double balance, double rate, Bank bank) {
        super(number, balance, bank);
        this.rate = rate;
    }

    public LivretA() {}

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
