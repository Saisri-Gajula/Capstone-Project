package com.capstone.collectionprocesshandling.Model;


import java.time.LocalDate;


// import jakarta.persistence.EmbeddedId;
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
public class dunningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalDate dueDate;
    
    @ManyToOne
    CustomerEntity customer;

    // public dunningEntity(int id, LocalDate date,CustomerEntity customer){
    //     this.id = id;
    //     this.dueDate=date;
    //     this.customer=customer;
    // }
    
}
