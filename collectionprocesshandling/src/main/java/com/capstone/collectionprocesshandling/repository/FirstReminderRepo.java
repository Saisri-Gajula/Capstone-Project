package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.model.FirstReminderRequest;

public interface FirstReminderRepo extends JpaRepository<FirstReminderRequest,Integer>{
    
    FirstReminderRequest findByPhoneNumber(String phoneNumber);
    
}
