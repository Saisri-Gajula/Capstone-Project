package com.capstone.collectionprocesshandling.Model;

import java.time.LocalDate;

// import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
    String name;
    String mailId;
    String  phoneNumber;
    LocalDate dueDate;
    // private PaymentHistory paymentHistory;
}
