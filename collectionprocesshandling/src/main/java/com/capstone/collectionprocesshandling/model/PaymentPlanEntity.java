package com.capstone.collectionprocesshandling.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PaymentPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int paidmaount;
    int dueamount;
    LocalDate duedate;
     @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
