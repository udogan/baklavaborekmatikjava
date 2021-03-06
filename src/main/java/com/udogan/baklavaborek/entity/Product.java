package com.udogan.baklavaborek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Product extends CreatedUpdatedAt {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    @Column
    private String name;
    
    protected Product() {
        //JPA Only
    }
    
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
