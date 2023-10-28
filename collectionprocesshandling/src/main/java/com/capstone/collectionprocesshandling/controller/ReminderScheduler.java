package com.capstone.collectionprocesshandling.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;
import com.capstone.collectionprocesshandling.service.ReminderService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Component
public class ReminderScheduler {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private FirstReminderRepo reminderRepo;

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
            if((ChronoUnit.DAYS.between((Temporal) customerDueDate,currentDate)) > 5 && (ChronoUnit.DAYS.between((Temporal) customerDueDate,currentDate))<10){
                System.out.println("1st reminder");
                 
            reminderService.sendReminderSms(phoneNumber, customerName,1);
            }
           else if((ChronoUnit.DAYS.between((Temporal) customerDueDate,currentDate))>10 && (ChronoUnit.DAYS.between((Temporal) customerDueDate,currentDate))<15){
            System.out.println("2nd reminder");
            reminderService.sendReminderSms(phoneNumber, customerName,2);
           }
           else if((ChronoUnit.DAYS.between((Temporal) customerDueDate,currentDate))>15){
                System.out.println("Termination reminder");
                 reminderService.sendReminderSms(phoneNumber, customerName,3);

           }
            // // Increment the reminder level
            // int newReminderLevel = reminder.getReminder_level() + 1;
            // reminder.setReminder_level(newReminderLevel);
            // reminderRepo.save(reminder);
        }
    }
}