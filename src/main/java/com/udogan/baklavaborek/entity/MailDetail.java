package com.udogan.baklavaborek.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class MailDetail extends CreatedUpdatedAt {
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    private Order order;
    
    @ManyToOne
    @JoinColumn(name="mailSentBy")
    private User mailSentBy;
    
    @NotNull
    @Column(nullable=false)
    private Date mailDate;
    
    @NotNull
    @Column(nullable=false)
    @Lob
    private String mailBody;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getMailSentBy() {
        return mailSentBy;
    }

    public void setMailSentBy(User mailSentBy) {
        this.mailSentBy = mailSentBy;
    }

    public Date getMailDate() {
        return mailDate;
    }

    public void setMailDate(Date mailDate) {
        this.mailDate = mailDate;
    }

    public String getMailBody() {
        return mailBody;
    }

    public void setMailBody(String mailBody) {
        this.mailBody = mailBody;
    }

    public Long getId() {
        return id;
    }
}
