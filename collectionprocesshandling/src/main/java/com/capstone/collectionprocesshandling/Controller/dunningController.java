package com.capstone.collectionprocesshandling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.Model.dunningEntity;
// import com.capstone.collectionprocesshandling.Model.dunningEntity;
import com.capstone.collectionprocesshandling.service.dunningService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class dunningController {
    @Autowired
    private dunningService dunningservice;

    @GetMapping("/dunningPays")
    public List<dunningEntity> dunningdues(){
        dunningservice.getdunningpays();
        System.out.println("heyy" + dunningservice.dunningpays());
        return dunningservice.dunningpays();
    }
}
