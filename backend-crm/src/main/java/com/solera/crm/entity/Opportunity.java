package com.solera.crm.entity;

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
    private boolean successful;
    @ManyToOne
    @JoinColumn(name = "client_ID")
    private Client client;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "opportunity", cascade = CascadeType.ALL)
    private Set<Contact> contacts = new java.util.LinkedHashSet<>();

    // CONSTRUCTORS
    public Opportunity() {
    }

    public Opportunity(boolean successful, Client client) {
        this.successful = successful;
        this.client = client;
    }

    // METHODS
    public Long getId() {
        return id;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
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
}
