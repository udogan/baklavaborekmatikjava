package com.udogan.baklavaborek.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Item extends CreatedUpdatedAt  {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull
    @Column(nullable=false)
    private Integer quantity;
    
    @ManyToOne
    private Measurement measurement;
    
    @ManyToOne
    private Product product;
    
    @ManyToOne
    private Order order;
    
    protected Item() {
      //JPA Only
    }
    
    public Item(Integer quantity, Measurement measurement, Product product, Order order) {
        this.quantity = quantity;
        this.measurement = measurement;
        this.product = product;
        this.order = order;
    }
    
    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
