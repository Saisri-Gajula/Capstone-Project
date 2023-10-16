package com.capstone.collectionprocesshandling.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
    
}
