package com.solera.crm.entity;

import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Scope("session")
public class User {

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

    // CONSTRUCTORS
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

}