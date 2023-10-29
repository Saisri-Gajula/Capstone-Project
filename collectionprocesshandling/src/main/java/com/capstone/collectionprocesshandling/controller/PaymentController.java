package com.capstone.collectionprocesshandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capstone.collectionprocesshandling.service.PaymentHistoryService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PaymentController {
   
    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping("/add-payment/{phoneNumber}")
    public void addCustomer(@PathVariable String phoneNumber) {
        paymentHistoryService.paidCustomer(phoneNumber);
    }
}
