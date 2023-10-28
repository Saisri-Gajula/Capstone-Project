package com.capstone.collectionprocesshandling.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.CustomerIdSequence;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.CustomerIdSequenceRepo;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private DunningRepo dunningRepo;
    
    @Autowired
    private CustomerIdSequenceRepo customerIdSequenceRepo;

    public CustomerEntity getCustomerById(int id){
        return customerRepo.findById(id).orElse(null);
    }


    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    // public CustomerService(CustomerRepo customerRepo2, CustomerIdSequenceRepo customerIdSequenceRepo2) {
    // }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }


    public CustomerEntity createCustomer(CustomerEntity customer) {
        CustomerIdSequence sequence = customerIdSequenceRepo.findById(1).orElse(new CustomerIdSequence());
        int nextId = sequence.getNextId();

        // Set the customer's ID and update the sequence
        customer.setId(nextId);
        sequence.setNextId(nextId + 1);
        customerIdSequenceRepo.save(sequence);
       
        return customerRepo.save(customer);
    }

    public void updateCustomer(CustomerEntity customer) {
        customerRepo.save(customer);
    }
    
    public void deleteCustomer(int customerId) {
        customerRepo.deleteById(customerId);

        // Decrement the ID sequence value when a customer is deleted
        CustomerIdSequence sequence = customerIdSequenceRepo.findById(1).orElse(new CustomerIdSequence());
        int currentId = sequence.getNextId();
        if (customerId < currentId) {
            sequence.setNextId(currentId - 1);
            customerIdSequenceRepo.save(sequence);
        }
    }
}
