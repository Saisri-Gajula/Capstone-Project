package com.capstone.collectionprocesshandling.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerservice;
    
    @Autowired
    private DunningRepo dunningRepo;
    @Autowired
    private CustomerRepo customerRepo;
   
    public static final String ACCOUNT_SID = System.getenv("ACcc86f0beae31ed1b268f47aa911b229a");
    public static final String AUTH_TOKEN = System.getenv("bbd48e50cbbf141214e40f20e702aeb1");
    

    @GetMapping("/customers")
    public List<CustomerEntity> getcustomers(){
       
        return customerservice.getAllCustomers();
    }
    
	

@PostMapping("/add-customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        customer.setAmount(5000);
        customerRepo.save(customer);
         DunningEntity dunning= new DunningEntity();
        dunning.setDueDate(LocalDate.now().minusDays(17));
        dunning.setCustomer(customer);
        dunning.setAmount(2500);
        dunningRepo.save(dunning); 

        return customer;
    }
}
