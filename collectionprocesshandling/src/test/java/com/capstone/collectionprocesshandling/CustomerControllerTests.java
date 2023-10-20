// package com.capstone.collectionprocesshandling;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// import com.capstone.collectionprocesshandling.Controller.CustomerController;
// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.service.customerService;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;

// @SpringBootTest
// public class CustomerControllerTests {

//     @Autowired
//     private customerService customerService;

//     @MockBean
//     private CustomerRepo customerrepo;
    
//     @InjectMocks
//     private CustomerController customerController;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         customerController = new CustomerController(customerService);
//     }

//     @Test
//     public void testGetCustomers_Success() {
//         LocalDate date = LocalDate.now();
//         CustomerEntity customer1 = new CustomerEntity(1, "Alice", "alice@example.com", "12345",date);
//         CustomerEntity customer2 = new CustomerEntity(2, "Bob", "bob@example.com", "67890",date);
//         List<CustomerEntity> customers = new ArrayList<>();
//         customers.add(customer1);
//         customers.add(customer2);

//         when(customerService.getcustomers()).thenReturn(customers);
//         when(customerrepo.findAll()).thenReturn(customers);

//         List<CustomerEntity> response =  customerController.getcustomers();

//         // assertEquals(HttpStatus.OK, response.getStatusCode());

//         List<CustomerEntity> result = response;
//         assertEquals(2, result.size());
//         assertEquals("Alice", result.get(0).getName());
//         assertEquals("Bob", result.get(1).getName());
//     }
// }
