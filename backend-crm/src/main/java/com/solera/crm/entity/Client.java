package com.solera.crm.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    // PROPERTIES
    @Id
    @SequenceGenerator(
            name = "client_seq",
            sequenceName = "client_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "client_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Opportunity> opportunities = new java.util.LinkedHashSet<>();
    @OneToMany(mappedBy = "opportunity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Contact> contacts = new java.util.LinkedHashSet<>();

    // CONSTRUCTORS
    public Client() {
    }

    public Client(Set<Opportunity> opportunities, Set<Contact> contacts) {
        this.opportunities = opportunities;
        this.contacts = contacts;
    }

    // METHODS
    public Long getId() {
        return id;
    }

    public Set<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Set<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public void addOpportunity(Opportunity opportunity) {
        this.opportunities.add(opportunity);
    }

    public void removeOpportunity(Opportunity opportunity) {
        this.opportunities.remove(opportunity);
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        this.contacts.remove(contact);
    }

}
