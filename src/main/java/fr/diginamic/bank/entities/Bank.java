package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Bank entity in the bank system.
 * It is a concrete class that represents a bank.
 * It is linked to the Account entity.
 */
@Entity
@Table(name = "bank")
public class Bank {
    /**
     * The unique identifier of the bank.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The name of the bank.
     */
    @Column(name = "name")
    private String name;

    /**
     * The set of accounts that belong to the bank.
     */
    @OneToMany(mappedBy = "bank")
    private Set<Account> accounts = new HashSet<>();

    /**
     * Constructor for creating a new Bank with specified name.
     * @param name The name of the bank.
     */
    public Bank(String name) {
        this.name = name;
    }

    /**
     * Default constructor for creating a new Bank.
     */
    public Bank() {}

    /**
     * Set the name of the bank.
     * @param name The name of the bank.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the name of the bank.
     * @return The name of the bank.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the unique identifier of the bank.
     * @param id The unique identifier of the bank.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the unique identifier of the bank.
     * @return The unique identifier of the bank.
     */
    public int getId() {
        return id;
    }

    /**
     * Get the set of accounts that belong to the bank.
     * @return The set of accounts that belong to the bank.
     */
    public Set<Account> getAccounts() {
        return accounts;
    }

    /**
     * Add an account to the set of accounts that belong to the bank.
     * @param account The account to add to the set of accounts.
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Remove an account from the set of accounts that belong to the bank.
     * @param account The account to remove from the set of accounts.
     */
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    /**
     * Set the set of accounts that belong to the bank.
     * @param accounts The set of accounts that belong to the bank.
     */
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
