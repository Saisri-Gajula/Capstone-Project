package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.model.PaymentHistory;

public interface PaymentHistoryRepo extends JpaRepository<PaymentHistory, Integer>{
    
}
