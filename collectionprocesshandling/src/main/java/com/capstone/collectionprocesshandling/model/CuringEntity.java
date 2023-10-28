package com.capstone.collectionprocesshandling.model;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;                                                                              
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CuringEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String servicePlan;
    String status; //premium or basic``    
    Date dueDate;
    int amount;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
