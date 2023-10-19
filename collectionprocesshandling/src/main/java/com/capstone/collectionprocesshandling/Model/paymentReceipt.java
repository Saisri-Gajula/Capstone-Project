package com.capstone.collectionprocesshandling.Model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class paymentReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int receiptNumber;
    double amount;
    LocalDate dueDate;

    @ManyToOne
    CustomerEntity customer;

    
}
