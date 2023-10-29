package com.capstone.collectionprocesshandling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.service.DunningService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DunningController {
    @Autowired
    private DunningService dunningservice;

    @GetMapping("/dunningPays")
    public List<DunningEntity> dunningdues(){
        return dunningservice.dunningpays();
    }
}
