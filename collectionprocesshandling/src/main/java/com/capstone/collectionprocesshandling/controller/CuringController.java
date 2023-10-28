package com.capstone.collectionprocesshandling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.model.CuringEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.service.CuringService;
import com.capstone.collectionprocesshandling.service.ReminderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CuringController {
    private final CuringService curingService;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    public CuringController(CuringService curingService) {
        this.curingService = curingService;
    }

    @GetMapping("/curingprocess")
    public ResponseEntity<List<CuringEntity>> getAllCuringRecords() {
        
        List<CuringEntity> curingEntities = curingService.getAllCuringRecords();
        return new ResponseEntity<>(curingEntities, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CuringEntity> createCuringRecord(@RequestBody CuringEntity curingEntity) {
        CuringEntity createdCuringEntity = curingService.createCuringRecord(curingEntity);
        return new ResponseEntity<>(createdCuringEntity, HttpStatus.CREATED);
    }
    
    @GetMapping("/curing")
    public List<FirstReminderRequest> dunningdues(){
        // dunningservice.getdunningpays();
        // System.out.println("heyy" + dunningservice.dunningpays());
       System.out.println(reminderService.curingreminders()); 

        return reminderService.curingreminders();
    }
    
}
