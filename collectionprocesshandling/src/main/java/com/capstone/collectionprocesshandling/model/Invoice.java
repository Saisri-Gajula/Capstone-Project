package com.capstone.collectionprocesshandling.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int invoiceId;
    double amountDue;
    Date dueDate;

    @ManyToOne
    CustomerEntity customer;
    
}
