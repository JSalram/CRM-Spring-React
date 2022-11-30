package com.solera.crm.entity;

import com.sun.istack.NotNull;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Scope("session")
public class User {

    // ROLES
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";

    // PROPERTIES
    @Id
    @SequenceGenerator(
            name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_seq"
    )
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String role;
    private String token;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Opportunity> opportunities = new LinkedHashSet<>();

    // CONSTRUCTORS
    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.token = "";
    }

    // METHODS
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Opportunity> getOpportunities() {
        return opportunities;
    }

    public void setOpportunities(Set<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    public void addOpportunity(Opportunity opportunity) {
        opportunity.setUser(this);
        this.opportunities.add(opportunity);
    }

    public void removeOpportunity(Opportunity opportunity) {
        opportunity.setUser(null);
        this.opportunities.remove(opportunity);
    }
}