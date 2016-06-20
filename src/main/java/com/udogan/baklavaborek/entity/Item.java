package com.udogan.baklavaborek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item extends CreatedUpdatedAt  {
    @Id
    @GeneratedValue
    private Long id;
    
    private Integer quantity;
    
    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
