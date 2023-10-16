package com.capstone.collectionprocesshandling.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.Model.paymentReceipt;
// import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.Repository.dunningRepo;

@Service
public class dunningService {
    @Autowired
    private dunningRepo dunningrepo;
    

    public List<paymentReceipt> getdunningpays(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate thresholdDate = currentDate.minusDays(5);
        // System.out.println(currentDate.minusDays(5));
        List<paymentReceipt> dunningPayments = dunningrepo.dunningPayments(thresholdDate);
        dunningEntity dunning = new dunningEntity();
        System.out.println(dunningPayments);
        for(paymentReceipt dunningPayment : dunningPayments){
            dunning.setCustomer(dunningPayment.getCustomer());
            dunning.setDueDate(dunningPayment.getDueDate());
        }
        dunningrepo.save(dunning);
        // System.out.println(dunningrepo.findAll());
        return dunningPayments;
    }

    public List<dunningEntity> dunningpays(){
        return dunningrepo.findAll();
    }
}