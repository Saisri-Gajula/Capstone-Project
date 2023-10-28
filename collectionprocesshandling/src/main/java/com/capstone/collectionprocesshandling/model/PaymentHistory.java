package com.capstone.collectionprocesshandling.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PaymentHistory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;

 @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    String phoneNumber;
    String status;//payment is done or not 
    Date date;

}
