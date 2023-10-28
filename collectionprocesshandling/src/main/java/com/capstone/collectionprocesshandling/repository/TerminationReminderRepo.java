package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.model.TerminationReminderRequest;

public interface TerminationReminderRepo extends JpaRepository<TerminationReminderRequest,Integer>{
    
}
