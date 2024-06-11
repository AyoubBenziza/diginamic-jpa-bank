package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a Client entity in the bank system.
 * It is a concrete class that represents a client.
 * It is linked to the Account entity.
 * It is linked to the Address entity.
 */
@Entity
@Table(name = "client")
public class Client {
    /**
     * The unique identifier of the client.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The first name of the client.
     */
    @Column(name = "firstName")
    private String firstName;

    /**
     * The last name of the client.
     */
    @Column(name = "lastName")
    private String lastName;

    /**
     * The birthdate of the client.
     */
    @Column(name = "birthDate")
    private LocalDate birthDate;

    /**
     * The address of the client.
     */
    @Embedded
    private Address address;

    /**
     * The set of accounts that belong to the client.
     */
    @ManyToMany
    @JoinTable(name = "client_account",
            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_account", referencedColumnName = "number"))

    private Set<Account> accounts = new HashSet<>();

    /**
     * Constructor for creating a new Client with specified first name, last name, birthdate, and address.
     * @param firstName The first name of the client.
     * @param lastName The last name of the client.
     * @param birthDate The birthdate of the client.
     * @param address The address of the client.
     */
    public Client(String firstName, String lastName, LocalDate birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    /**
     * Default constructor for creating a new Client.
     */
    public Client() {}

    /**
     * Set the unique identifier of the client.
     * @param id The unique identifier of the client.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the unique identifier of the client.
     * @return The unique identifier of the client.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the first name of the client.
     * @param firstName The first name of the client.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the first name of the client.
     * @return The first name of the client.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the last name of the client.
     * @param lastName The last name of the client.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the last name of the client.
     * @return The last name of the client.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the birthdate of the client.
     * @param birthDate The birthdate of the client.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the birthdate of the client.
     * @return The birthdate of the client.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set the accounts that belong to the client.
     * @param accounts The accounts that belong to the client.
     */
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Get the accounts that belong to the client.
     * @return The accounts that belong to the client.
     */
    public Set<Account> getAccounts() {
        return accounts;
    }

    /**
     * Add an account to the client.
     * @param account The account to add to the client.
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Remove an account from the client.
     * @param account The account to remove from the client.
     */
    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    /**
     * Clear all accounts from the client.
     */
    public void clearAccounts() {
        accounts.clear();
    }
}
