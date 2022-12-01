package com.solera.crm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private String description;
    private Date date;
    private String type;
    private boolean completed;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "opportunity_id")
    private Opportunity opportunity;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    // CONSTRUCTORS
    public Contact() {
    }

    public Contact(String description, Date date, String type, boolean completed) {
        this.description = description;
        this.date = date;
        this.type = type;
        this.completed = completed;
        this.client = null;
    }

    // METHODS
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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