package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.util.Set;

/**
 * This class represents an Account entity in the bank system.
 * It is an abstract class that holds common attributes and methods for all types of accounts.
 * It is linked to the Bank, Operation, and Client entities.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
public abstract class Account {
    /**
     * The unique number of the account.
     */
    @Id
    private int number;

    /**
     * The current balance of the account.
     */
    @Column(name = "balance")
    private double balance;

    /**
     * The bank that the account belongs to.
     */
    @ManyToOne
    private Bank bank;

    /**
     * The set of operations performed on the account.
     */
    @OneToMany(mappedBy = "account")
    private Set<Operation> operations;

    /**
     * The set of clients that own the account.
     */
    @ManyToMany
    @JoinTable(name = "client_account",
            joinColumns = @JoinColumn(name = "id_account", referencedColumnName = "number"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
    private Set<Client> clients;

    /**
     * Constructor for creating a new Account with specified number, balance, and bank.
     * @param number The unique number of the account.
     * @param balance The initial balance of the account.
     * @param bank The bank that the account belongs to.
     */
    protected Account(int number, double balance, Bank bank) {
        this.number = number;
        this.balance = balance;
        this.bank = bank;
    }

    /**
     * Default constructor for Account.
     */
    public Account() {}

    /**
     * Getter for the number attribute.
     * @return The number of the account.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter for the number attribute.
     * @param number The new number of the account.
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Setter for the balance attribute.
     * @param balance The new balance of the account.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getter for the balance attribute.
     * @return The current balance of the account.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter for the bank attribute.
     * @param bank The new bank that the account belongs to.
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * Getter for the bank attribute.
     * @return The bank that the account belongs to.
     */
    public Bank getBank() {
        return bank;
    }

    /**
     * Setter for the operations attribute.
     * @param operations The new set of operations performed on the account.
     */
    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    /**
     * Getter for the operations attribute.
     * @return The set of operations performed on the account.
     */
    public Set<Operation> getOperations() {
        return operations;
    }

    /**
     * Setter for the clients attribute.
     * @param clients The new set of clients that own the account.
     */
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    /**
     * Getter for the clients attribute.
     * @return The set of clients that own the account.
     */
    public Set<Client> getClients() {
        return clients;
    }

    /**
     * Adds a client to the set of clients that own the account.
     * @param client The client to add to the set of clients.
     */
    public void setClient(Client client) {
        clients.add(client);
    }

    /**
     * Adds an operation to the set of operations performed on the account.
     * @param operation The operation to add to the set of operations.
     */
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    /**
     * Withdraws a specified amount from the account.
     * @param amount The amount to withdraw from the account.
     */
    public void credit(double amount) {
        balance += amount;
    }
}
