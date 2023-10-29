package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone.collectionprocesshandling.model.SecondReminderRequest;

public interface SecondreminderRepo extends JpaRepository<SecondReminderRequest, Integer>{
    SecondReminderRequest findByPhoneNumber(String phoneNumber);
}
