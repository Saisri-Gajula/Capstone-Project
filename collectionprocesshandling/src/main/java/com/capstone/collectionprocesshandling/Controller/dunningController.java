package com.capstone.collectionprocesshandling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.Model.paymentReceipt;
// import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.service.dunningService;

@RestController
@RequestMapping("/api")
public class dunningController {
    @Autowired
    private dunningService dunningservice;

    @GetMapping("/dunningPays")
    public List<dunningEntity> dunningdues(){
        dunningservice.getdunningpays();
        System.out.println(dunningservice.dunningpays());
        return dunningservice.dunningpays();
    }
}
