package com.capstone.collectionprocesshandling.repository;

import com.capstone.collectionprocesshandling.model.PaymentPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPlanRepo extends JpaRepository<PaymentPlanEntity, Integer> {
}
