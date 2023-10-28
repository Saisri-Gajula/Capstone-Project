package com.capstone.collectionprocesshandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.model.SecondReminderRequest;
import com.capstone.collectionprocesshandling.model.TerminationReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.service.ReminderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ReminderController {
    
    @Autowired
    private ReminderService reminderService;

    @Autowired
    private Smsrequest smsrequest;

    @Autowired
    private CustomerRepo customerRepo;
@GetMapping("/send-sms/{phoneNumber}")
public ResponseEntity<String> sendReminderSms(@PathVariable String phoneNumber) {
    CustomerEntity customer = customerRepo.findByPhoneNumber(phoneNumber);
    String status= reminderService.sendReminderSms(phoneNumber,customer.getName(),1);
    if("sent".equals(status)||"queued".equals(status)){
        return ResponseEntity.ok().body("sent successfully");
    }
 return ResponseEntity.ok().body("Failed to send message");
}

    @GetMapping("/initialReminders")
    public List<FirstReminderRequest> initialreminders(){
        return reminderService.firstReminders();
    }

    @GetMapping("/secondReminders")
    public List<SecondReminderRequest> nextreminders(){
        return reminderService.secondreminders();
    }

    @GetMapping("/terminationReminders")
    public List<TerminationReminderRequest> terminationreminders(){
        return reminderService.terminationReminders();
    }
    
}