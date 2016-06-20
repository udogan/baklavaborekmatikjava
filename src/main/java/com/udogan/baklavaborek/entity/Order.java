package com.udogan.baklavaborek.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="`Order`")
public class Order extends CreatedUpdatedAt {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy="order")
    private Set<Item> items;
    
    @Column
    private Date willPurchaseDate;
    
    @Column
    private Date purchaseDate;
    
    @OneToOne(mappedBy="order")
    private MailDetail mailDetail;
    
    protected Order() {
        //JPA Only
    }
    
    public Order(User user, Set<Item> items, Date willPurchaseDate, Date purchaseDate, MailDetail mailDetail) {
        this.user = user;
        this.items = items;
        this.willPurchaseDate = willPurchaseDate;
        this.purchaseDate = purchaseDate;
        this.mailDetail = mailDetail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public Date getWillPurchaseDate() {
        return willPurchaseDate;
    }

    public void setWillPurchaseDate(Date willPurchaseDate) {
        this.willPurchaseDate = willPurchaseDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public MailDetail getMailDetail() {
        return mailDetail;
    }

    public void setMailDetail(MailDetail mailDetail) {
        this.mailDetail = mailDetail;
    }

    public Long getId() {
        return id;
    }
}
