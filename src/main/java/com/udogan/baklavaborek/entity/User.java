package com.udogan.baklavaborek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class User extends CreatedUpdatedAt {
    
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;
    
    @NotBlank
    @Column(nullable = false, length = 100)
    private String surname;
    
    @NotBlank
    @Email
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    
    protected User() {
        //JPA Only
    }

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
