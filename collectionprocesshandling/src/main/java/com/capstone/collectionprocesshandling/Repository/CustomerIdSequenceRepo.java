package com.capstone.collectionprocesshandling.Repository;

import org.springframework.data.repository.CrudRepository;

import com.capstone.collectionprocesshandling.Model.CustomerIdSequence;

public interface CustomerIdSequenceRepo extends CrudRepository<CustomerIdSequence, Integer> {
}
