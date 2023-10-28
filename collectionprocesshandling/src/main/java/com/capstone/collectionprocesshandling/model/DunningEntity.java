package com.capstone.collectionprocesshandling.model;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DunningEntity {
    public DunningEntity(int i, LocalDate dueDate2, int j) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
