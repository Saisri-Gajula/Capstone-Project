// package com.capstone.collectionprocesshandling;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.eq;
// import static org.mockito.Mockito.doAnswer;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import com.capstone.collectionprocesshandling.model.CustomerEntity;
// import com.capstone.collectionprocesshandling.model.CustomerIdSequence;
// import com.capstone.collectionprocesshandling.repository.CustomerIdSequenceRepo;
// import com.capstone.collectionprocesshandling.repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.service.CustomerService;
// @SpringBootTest
// class CustomerServiceTests {

//     @Autowired
//     private CustomerService customerservice;
    

//     @MockBean
//     private CustomerRepo customerRepo;

//     @MockBean
//     private CustomerIdSequenceRepo customerIdSequenceRepo;

//     @BeforeEach
//     void setup(){
//         LocalDate date = LocalDate.now();
//         Optional<CustomerEntity> Customer = Optional.of(new CustomerEntity(1,"sai","saisri@gmail.com","84562936",date,"Tv"));
//         Mockito.when(customerRepo.findById(1)).thenReturn(Customer);
//     }
//     @Test
//    public void testGetCustomerById_Success(){
//         String customer_name = "sai";
       
//         CustomerEntity customerById =  customerservice.getCustomerById(1);

//         assertEquals(customer_name , customerById.getName());
//     }


//     @Test
//     public void testGetCustomers() {
//         // Arrange
//         List<CustomerEntity> customers = new ArrayList<>();
//                 LocalDate date = LocalDate.now();

//         customers.add(new CustomerEntity(1, "Customer1", "customer1@example.com", "1234567890",date,"Tv"));
//         customers.add(new CustomerEntity(2, "Customer2", "customer2@example.com", "9876543210",date,"Tv"));

//         when(customerRepo.findAll()).thenReturn(customers);

//         // Act
//         List<CustomerEntity> result = customerservice.getAllCustomers();

//         // Assert
//         assertEquals(customers.size(), result.size());
//         // You can add more assertions based on your use case
//     }


//     @Test
//     public void testCreateCustomer() {
//         // Arrange
//         CustomerEntity customerToCreate = new CustomerEntity();
//         customerToCreate.setName("New Customer");
//         customerToCreate.setMailId("newcustomer@example.com");
//         customerToCreate.setPhoneNumber("9876543210");

//         CustomerIdSequence sequence = new CustomerIdSequence();
//         sequence.setNextId(100);  // Set an initial ID sequence

//         // when(customerRepo.findById(1)).thenReturn(Optional.of(customerToCreate));
//         when(customerIdSequenceRepo.findById(100)).thenReturn(Optional.of(sequence));
//         when(customerRepo.save(any())).thenAnswer(invocation -> {
//             CustomerEntity savedCustomer = invocation.getArgument(0);
//             // Simulate saving the customer with an updated ID
//             savedCustomer.setId(sequence.getNextId());
//             // Update the sequence
//             sequence.setNextId(sequence.getNextId() + 1);
//             return savedCustomer;
//         });

//         // Act
//         CustomerEntity createdCustomer = customerservice.createCustomer(customerToCreate);

//         // Assert
//         assertEquals("New Customer", createdCustomer.getName());
//         assertEquals(100, createdCustomer.getId());  // Ensure the ID is set correctly
//         // You can add more assertions based on your use case
//     }

//     @Test
//     public void testUpdateCustomer() {
//         // Arrange
//                 LocalDate date = LocalDate.now();

//         CustomerEntity customerToUpdate = new CustomerEntity(1, "Updated Customer", "updated@example.com", "9876543210",date,"Tv");

//         // Mock the save method of customerRepo
//         when(customerRepo.save(any(CustomerEntity.class))).thenAnswer(invocation -> {
//             // Return the saved customer entity
//             return invocation.getArgument(0);
//         });

//         // Act
//         customerservice.updateCustomer(customerToUpdate);

//         // Assert
//         // Verify that the save method was called with the updated customer
//         verify(customerRepo).save(eq(customerToUpdate));
//         // You can add more assertions based on your use case
//     }
//     @Test
//     public void testDeleteCustomer_CustomerIdLessThanCurrentId() {
//         // Arrange
//         int customerIdToDelete = 1;
//         int initialNextId = 101;
//             LocalDate date = LocalDate.now();

//         // Mock the findById method of customerRepo to return the customer to be deleted
//         when(customerRepo.findById(customerIdToDelete)).thenReturn(Optional.of(new CustomerEntity(customerIdToDelete, "Deleted Customer", "deleted@example.com", "9876543210",date,"Tv")));
    
//         CustomerIdSequence sequence = new CustomerIdSequence();
//         sequence.setNextId(initialNextId);  // Set an initial ID sequence
    
//         when(customerIdSequenceRepo.findById(1)).thenReturn(Optional.of(sequence));
//         doAnswer(invocation -> {
//             // Simulate deleting the customer
//             int deletedCustomerId = invocation.getArgument(0);
//             if (deletedCustomerId < sequence.getNextId()) {
//                 sequence.setNextId(sequence.getNextId() - 1);
//             }
//             return null;
//         }).when(customerRepo).deleteById(customerIdToDelete);
    
//         // Act
//         customerservice.deleteCustomer(customerIdToDelete);
    
//         // Assert
//         // Verify that the deleteById method was called with the correct customer ID
//         verify(customerRepo).deleteById(eq(customerIdToDelete));
    
//         // Verify that the ID sequence was updated correctly
//         assertEquals(initialNextId-2, sequence.getNextId());
    
//         // You have successfully covered the branch where customerId is less than currentId
//     }
    
    

// }
