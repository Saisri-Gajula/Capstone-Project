package com.capstone.collectionprocesshandling.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.Model.paymentReceipt;

// import ch.qos.logback.core.net.SyslogOutputStream;

public interface dunningRepo extends JpaRepository<dunningEntity, Integer>{
        @Query("SELECT c FROM paymentReceipt c WHERE c.dueDate < :thresholdDate")
         List<paymentReceipt> dunningPayments(LocalDate thresholdDate);

         @Query("SELECT d FROM dunningEntity d WHERE d.customer = :customer")
        List<dunningEntity> findByCustomer(CustomerEntity customer) ;
           
        
}
