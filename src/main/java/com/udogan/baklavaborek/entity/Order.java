package com.udogan.baklavaborek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="`Order`")
public class Order extends CreatedUpdatedAt {
    @Id
    @GeneratedValue
    private Long id;
}
