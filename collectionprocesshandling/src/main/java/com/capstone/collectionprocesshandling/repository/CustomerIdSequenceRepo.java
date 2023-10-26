package com.capstone.collectionprocesshandling.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.collectionprocesshandling.model.CustomerIdSequence;

@Repository
public interface CustomerIdSequenceRepo extends CrudRepository<CustomerIdSequence, Integer> {
}
