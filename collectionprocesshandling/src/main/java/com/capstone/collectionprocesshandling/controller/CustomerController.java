package com.capstone.collectionprocesshandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerservice;
    
    @Autowired
    private CustomerRepo customerRepo;
   
    public static final String ACCOUNT_SID = System.getenv("ACcc86f0beae31ed1b268f47aa911b229a");
    public static final String AUTH_TOKEN = System.getenv("bbd48e50cbbf141214e40f20e702aeb1");
    
    // public CustomerController() {
    //     // Default constructor
    // }
    
    // public CustomerController(CustomerRepo customerRepo) {
    // }
    // public CustomerController(CustomerService customerService2) {
    // }

    // public CustomerController(CustomerService customerService2, CustomerRepo customerRepo2) {
    // }

    @GetMapping("/customers")
    public List<CustomerEntity> getcustomers(){
       
        return customerservice.getAllCustomers();
    }
    
	
   

@PostMapping("/add-customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerRepo.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        customerservice.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
}
