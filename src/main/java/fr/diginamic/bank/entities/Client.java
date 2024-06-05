package fr.diginamic.bank.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Embedded
    private Address address;

    @ManyToMany
    @JoinTable(name = "client_account",
            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_account", referencedColumnName = "number"))

    private Set<Account> accounts = new HashSet<>();

    public Client(String firstName, String lastName, LocalDate birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public Client() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void clearAccounts() {
        accounts.clear();
    }
}
