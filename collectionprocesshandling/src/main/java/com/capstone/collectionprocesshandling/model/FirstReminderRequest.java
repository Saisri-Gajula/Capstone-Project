package com.capstone.collectionprocesshandling.model;


import java.time.LocalDate;
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
public class FirstReminderRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reminder_id;
    int reminder_level;
    String phoneNumber;
    LocalDate dueDate;
    String status; //unpaid or Plan

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
