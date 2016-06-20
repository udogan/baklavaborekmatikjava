package com.udogan.baklavaborek.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Measurement extends CreatedUpdatedAt {
    @Id
    @GeneratedValue
    private Long id;
}
