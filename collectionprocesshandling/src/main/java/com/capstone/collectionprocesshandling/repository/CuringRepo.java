package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.model.CuringEntity;

public interface CuringRepo extends JpaRepository<CuringEntity, Integer>{
    
}
