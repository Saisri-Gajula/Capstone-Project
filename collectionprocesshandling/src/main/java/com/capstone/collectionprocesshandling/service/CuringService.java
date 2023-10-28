package com.capstone.collectionprocesshandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.collectionprocesshandling.model.CuringEntity;
import com.capstone.collectionprocesshandling.repository.CuringRepo;

@Service
public class CuringService {
    private final CuringRepo curingRepository;

    @Autowired
    public CuringService(CuringRepo curingRepository) {
        this.curingRepository = curingRepository;
    }

    public List<CuringEntity> getAllCuringRecords() {
        return curingRepository.findAll();
    }
    
    public CuringEntity createCuringRecord(CuringEntity curingEntity) {
        // You can add additional logic here if needed
        return curingRepository.save(curingEntity);
    }
}
