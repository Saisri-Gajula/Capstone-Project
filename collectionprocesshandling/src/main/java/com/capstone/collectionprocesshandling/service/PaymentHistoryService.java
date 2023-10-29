package com.capstone.collectionprocesshandling.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.PaymentHistory;
import com.capstone.collectionprocesshandling.model.SecondReminderRequest;
import com.capstone.collectionprocesshandling.model.TerminationReminderRequest;
import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.repository.PaymentHistoryRepo;
import com.capstone.collectionprocesshandling.repository.SecondreminderRepo;
import com.capstone.collectionprocesshandling.repository.TerminationReminderRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;

@Service
public class PaymentHistoryService {
    
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private TerminationReminderRepo terminationreminderRepo;

    @Autowired
    private SecondreminderRepo secondreminderRepo;

    @Autowired
    private FirstReminderRepo firstReminderRepo;

    @Autowired
    private PaymentHistoryRepo paymentHistoryRepo;

    @Autowired
    private DunningRepo dunningRepo;

    public void paidCustomer(String phoneNumber) {
        TerminationReminderRequest reminder = new TerminationReminderRequest();
        PaymentHistory payment= new PaymentHistory();
        DunningEntity dunning= new DunningEntity();
        SecondReminderRequest secondreminder=new SecondReminderRequest();
        FirstReminderRequest firstreminder= new FirstReminderRequest();
        CustomerEntity customer = new CustomerEntity();
        payment.setPhoneNumber(phoneNumber);
        payment.setCustomer(customerRepo.findByPhoneNumber(phoneNumber));
        payment.setStatus("paid");
        payment.setDate(new Date());
        payment.setTotalamount(5000);
        paymentHistoryRepo.save(payment);
        reminder= terminationreminderRepo.findByPhoneNumber(phoneNumber);
        terminationreminderRepo.delete(reminder);
        secondreminder=secondreminderRepo.findByPhoneNumber(phoneNumber);
        secondreminderRepo.delete(secondreminder);
        firstreminder=firstReminderRepo.findByPhoneNumber(phoneNumber);
        firstReminderRepo.delete(firstreminder);
        dunning = dunningRepo.findByCustomerId(customerRepo.findByPhoneNumber(phoneNumber).getId());
        dunningRepo.delete(dunning);
        
    }
}
