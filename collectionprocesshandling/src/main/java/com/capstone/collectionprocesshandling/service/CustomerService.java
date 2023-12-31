package com.capstone.collectionprocesshandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.CustomerIdSequence;
import com.capstone.collectionprocesshandling.repository.CustomerIdSequenceRepo;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private CustomerIdSequenceRepo customerIdSequenceRepo;

    public CustomerEntity getCustomerById(int id){
        return customerRepo.findById(id);
    }


    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<CustomerEntity> getAllCustomers() {
        return customerRepo.findAll();
    }


    public CustomerEntity createCustomer(CustomerEntity customer) {
        CustomerIdSequence sequence = customerIdSequenceRepo.findById(1).orElse(new CustomerIdSequence());
        int nextId = sequence.getNextId();

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

        CustomerIdSequence sequence = customerIdSequenceRepo.findById(1).orElse(new CustomerIdSequence());
        int currentId = sequence.getNextId();
        if (customerId < currentId) {
            sequence.setNextId(currentId - 1);
            customerIdSequenceRepo.save(sequence);
        }
    }
}
