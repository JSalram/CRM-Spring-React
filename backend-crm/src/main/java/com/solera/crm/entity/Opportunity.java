package com.solera.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "opportunity")
public class Opportunity {

    // PROPERTIES
    @Id
    @SequenceGenerator(
            name = "opportunity_seq",
            sequenceName = "opportunity_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "opportunity_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String lastName;
    private int phoneNumber;
    private String nif;
    private boolean successful;
    private boolean active = true;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_ID")
    private Client client;
    @OneToMany(mappedBy = "opportunity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new java.util.LinkedHashSet<>();
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    // CONSTRUCTORS
    public Opportunity() {
    }
    public Opportunity(String name, String lastName, int phoneNumber, String nif, boolean successful) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.nif = nif;
        this.successful = successful;
        this.client = null;
    }

    // METHODS
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public boolean isSuccessful() {
        return successful;
    }
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public Set<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
    public void addContact(Contact contact) {
        contact.setOpportunity(this);
        this.contacts.add(contact);
    }
    public void removeContact(Contact contact) {
        contact.setOpportunity(null);
        this.contacts.remove(contact);
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
