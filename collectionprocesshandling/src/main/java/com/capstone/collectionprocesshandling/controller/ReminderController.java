package com.capstone.collectionprocesshandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.service.ReminderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class ReminderController {
    
    @Autowired
    private ReminderService reminderService;

    @Autowired
    private Smsrequest smsrequest;

@GetMapping("/send-sms/{phoneNumber}")
public ResponseEntity<Object> sendReminderSms(@PathVariable String phoneNumber) {
    // phoneNumber= "7660842840";
    smsrequest.setNumber(phoneNumber);
    smsrequest.setMessage("Hi Srinath! I am Saisri! From purchasing app :):). You have due payments on purchased products. Please complete your payments. Otherwise We are going to terminate your account (or) Cancel your access to this products.");
    // System.out.println(smsrequest.getNumber());
    String status=reminderService.sendReminderSms(smsrequest);
    if("sent".equals(status)||"queued".equals(status)){
        return new ResponseEntity<Object>("sent successfully",HttpStatus.OK);
    }
 return new ResponseEntity<Object>("Failed to send message.",HttpStatus.NOT_FOUND);
}
}