package com.capstone.collectionprocesshandling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
import com.capstone.collectionprocesshandling.service.customerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CustomerController {
    // @Autowired
    // private CustomerRepo customerRepo;
    @Autowired
    private customerService customerservice;

    @GetMapping("/customers")
    public List<CustomerEntity> getcustomers(){
        System.out.println(customerservice.getcustomers());
        return customerservice.getcustomers();
    }


}
