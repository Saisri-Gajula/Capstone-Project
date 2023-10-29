package com.capstone.collectionprocesshandling.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.service.ReminderService;


@Component
public class ReminderScheduler {


    @Autowired
    private ReminderService reminderService;


    @Autowired
    private DunningRepo dunningRepo;

    @Scheduled(fixedRate = 3600000) 
    public void sendDueReminders() {
        List<DunningEntity> overdueReminders = dunningRepo.findAll();

        for (DunningEntity dunningdues : overdueReminders ) {
            // Send reminder to phoneNumber
            LocalDate currentDate = LocalDate.now();
            LocalDate customerDueDate = dunningdues.getDueDate();
            String phoneNumber = dunningdues.getCustomer().getPhoneNumber();
            String customerName = dunningdues.getCustomer().getName();
            if((ChronoUnit.DAYS.between( customerDueDate,currentDate)) > 5 && (ChronoUnit.DAYS.between( customerDueDate,currentDate))<10){
                 
            reminderService.sendReminderSms(phoneNumber, customerName,1);
            }
           else if((ChronoUnit.DAYS.between(customerDueDate,currentDate))>10 && (ChronoUnit.DAYS.between( customerDueDate,currentDate))<15){
            reminderService.sendReminderSms(phoneNumber, customerName,2);
           }
           else if((ChronoUnit.DAYS.between( customerDueDate,currentDate))>15){
                 reminderService.sendReminderSms(phoneNumber, customerName,3);

           }
           
        }
    }
}