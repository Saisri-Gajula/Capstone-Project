package com.capstone.collectionprocesshandling.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.model.PaymentReceipt;

// import ch.qos.logback.core.net.SyslogOutputStream;
@Repository
public interface DunningRepo extends JpaRepository<DunningEntity, Integer>{
        
        @Query("SELECT d FROM DunningEntity d WHERE d.dueDate < :thresholdDate")
        List<DunningEntity> dunningPayments(LocalDate thresholdDate);

        @Query("SELECT d FROM DunningEntity d WHERE d.customer = :customer")
        List<DunningEntity> findByCustomer(CustomerEntity customer);
        

        DunningEntity findByCustomerId(int id); 

        // @Query("SELECT d from Customer")

}
