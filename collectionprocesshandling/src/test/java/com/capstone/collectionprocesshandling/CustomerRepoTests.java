// package com.capstone.collectionprocesshandling;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.LocalDate;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// // import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.Repository.CustomerRepo;

// @DataJpaTest
// @AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
// class CustomerRepoTests {

//     @Autowired
//     private CustomerRepo customerRepo;

//     @Autowired
//     private TestEntityManager testEntityManager;

//     @BeforeEach
//     void setup() {
//         LocalDate date = LocalDate.now();
//         CustomerEntity customerEntity = new CustomerEntity(1, "sai", "mailId@gmail.com", "24562462", date);
//         testEntityManager.persist(customerEntity);
//     }

//     @Test
//     public void testFindById() {
//         CustomerEntity customerEntity = customerRepo.findById(1).orElse(null);
//         assertEquals("sai", customerEntity.getName());
//     }
// }
