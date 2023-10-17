package com.capstone.collectionprocesshandling.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Repository.CustomerRepo;

@Service
public class customerService {
    @Autowired
    private CustomerRepo customerRepo;

     public List<CustomerEntity> getcustomers(){
        return customerRepo.findAll();
    }

    public Optional<CustomerEntity> getCustomerById(int id){
        return customerRepo.findById(id);
    }
}
