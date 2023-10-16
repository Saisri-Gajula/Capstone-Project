package com.capstone.collectionprocesshandling.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int invoiceId;
    double amountDue;
    Date dueDate;
    PaymentMethod paymentMethod;
    paymentPlan paymentplan;

    @ManyToOne
    CustomerEntity customer;
    
}
