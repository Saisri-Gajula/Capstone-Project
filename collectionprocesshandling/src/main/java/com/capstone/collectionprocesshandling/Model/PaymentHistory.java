package com.capstone.collectionprocesshandling.Model;

import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int paymentId;
    Date paymentDate;
    int amount;
    // @OneToOne
    // PaymentMethod paymentMethod;
    // @OneToMany
    // PaymentStatus paymentStatus;
    // @ManyToMany
    // paymentPlan paymentplan;

    @ManyToOne
    CustomerEntity customer;
}