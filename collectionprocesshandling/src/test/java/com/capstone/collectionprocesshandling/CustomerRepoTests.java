package com.capstone.collectionprocesshandling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
@DataJpaTest
class CustomerRepoTests {
   
        @Autowired
        private CustomerRepo customerrepo;

        @Autowired
        private TestEntityManager entityManger;
        @BeforeEach
        void setup(){
            LocalDate date = LocalDate.now();
            CustomerEntity customerEntity = new CustomerEntity(1, "sai", "mailId", "24562462", date);
            entityManger.persist(customerEntity);
        }

        @Test
        public void testFindById(){
            CustomerEntity customerEntity = customerrepo.findById(1).get();
            assertEquals("sai",customerEntity.getName());
    }
    
}
