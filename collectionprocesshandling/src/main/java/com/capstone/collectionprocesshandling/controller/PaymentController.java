package com.capstone.collectionprocesshandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.PaymentHistory;
import com.capstone.collectionprocesshandling.repository.PaymentHistoryRepo;
import com.capstone.collectionprocesshandling.service.PaymentHistoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    private PaymentHistoryRepo paymentHistoryRepo; 
    @Autowired
    private PaymentHistoryService paymentHistoryService;
@GetMapping("/add-payment/{phoneNumber}")
    public void addCustomer(@PathVariable String phoneNumber) {

        paymentHistoryService.paidCustomer(phoneNumber);
        // return ResponseEntity.ok().body("Added Succesfully");
        

    }
}
