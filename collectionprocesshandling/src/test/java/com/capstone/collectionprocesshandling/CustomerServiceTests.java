// package com.capstone.collectionprocesshandling;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.time.LocalDate;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.service.customerService;
// @SpringBootTest
// class CustomerServiceTests {

//     @Autowired
//     private customerService customerservice;
    

//     @MockBean
//     private CustomerRepo customerRepo;

//     @BeforeEach
//     void setup(){
//         LocalDate date = LocalDate.now();
//         Optional<CustomerEntity> Customer = Optional.of(new CustomerEntity(1,"sai","saisri@gmail.com","84562936",date));
//         Mockito.when(customerRepo.findById(1)).thenReturn(Customer);
//     }
//     @Test
//    public void testGetCustomerById_Success(){
//         String customer_name = "sai";
       
//         CustomerEntity customerById =  customerservice.getCustomerById(1);

//         assertEquals(customer_name , customerById.getName());
//     }

// }
