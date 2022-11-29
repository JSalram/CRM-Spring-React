package com.solera.crm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact")
public class Contact {

    // PROPERTIES
    @Id
    @SequenceGenerator(
            name = "contact_seq",
            sequenceName = "contact_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "contact_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date;
    private String type;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // CONSTRUCTORS
    public Contact() {
    }

    public Contact(Date date, String type, boolean completed, Client client) {
        this.date = date;
        this.type = type;
        this.completed = completed;
        this.client = client;
    }

    // METHODS
    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Opportunity getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}