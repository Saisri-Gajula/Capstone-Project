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
public class SecondReminderRequest {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int reminderId;
    int reminderLevel;
    String phoneNumber;
    LocalDate dueDate;
    String status; //unpaid or Plan
    int dueamount;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
