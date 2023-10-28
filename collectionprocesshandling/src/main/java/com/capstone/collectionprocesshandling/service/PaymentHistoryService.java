package com.capstone.collectionprocesshandling.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.PaymentHistory;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.PaymentHistoryRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;

@Service
public class PaymentHistoryService {
    
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private FirstReminderRepo reminderRepo;

    @Autowired
    private PaymentHistoryRepo paymentHistoryRepo;

    public void paidCustomer(String phoneNumber) {
FirstReminderRequest reminder= new FirstReminderRequest();
        PaymentHistory payment= new PaymentHistory();
        payment.setPhoneNumber(phoneNumber);
        payment.setCustomer(customerRepo.findByPhoneNumber(phoneNumber));
        payment.setStatus("paid");
        payment.setDate(new Date());
        paymentHistoryRepo.save(payment);
       reminder= reminderRepo.findByPhoneNumber(phoneNumber);
        // reminderRepo.save(reminder);
        reminderRepo.delete(reminder);
    }
}
