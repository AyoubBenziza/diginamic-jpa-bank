package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
public abstract class Account {
    @Id
    private int number;

    @Column(name = "balance")
    private double balance;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "account")
    private Set<Operation> operations;

    @ManyToMany
    @JoinTable(name = "client_account",
            joinColumns = @JoinColumn(name = "id_account", referencedColumnName = "number"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))

    private Set<Client> clients;

    protected Account(int number, double balance, Bank bank) {
        this.number = number;
        this.balance = balance;
        this.bank = bank;
    }

    public Account() {}

    public void getNumber(int number) {
        this.number = number;
    }

    public void getBalance(double balance) {
        this.balance = balance;
    }

    public double setBalance() {
        return balance;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClient(Client client) {
        clients.add(client);
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public void credit(double amount) {
        balance += amount;
    }
}
