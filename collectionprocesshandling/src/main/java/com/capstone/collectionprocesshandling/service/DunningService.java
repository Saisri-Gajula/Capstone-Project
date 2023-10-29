package com.capstone.collectionprocesshandling.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.DunningRepo;

@Service
public class DunningService {
    @Autowired
    private DunningRepo dunningrepo;
    

    public DunningService(DunningRepo dunningrepo2) {
    }

    public List<DunningEntity> getdunningpays(){
        
        LocalDate currentDate = LocalDate.now();
        LocalDate thresholdDate = currentDate.minusDays(5);
        List<DunningEntity> dunningPayments = dunningrepo.dunningPayments(thresholdDate);
        for(DunningEntity dunningPayment : dunningPayments){
            if (!isCustomerInDunning(dunningPayment.getCustomer())) {
                DunningEntity dunning = new DunningEntity();
                dunning.setCustomer(dunningPayment.getCustomer());
                dunning.setDueDate(dunningPayment.getDueDate());
                dunningrepo.save(dunning);
            }
        }
        return dunningPayments;
    }

    public List<DunningEntity> dunningpays(){
        return dunningrepo.findAll();
    }

     public boolean isCustomerInDunning(CustomerEntity customer) {
        List<DunningEntity> existingDunningEntries = dunningrepo.findByCustomer(customer);
        return !existingDunningEntries.isEmpty();
    }
}
