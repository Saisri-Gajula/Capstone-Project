package com.capstone.collectionprocesshandling;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.CustomerIdSequence;
import com.capstone.collectionprocesshandling.repository.CustomerIdSequenceRepo;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.service.CustomerService;
@SpringBootTest
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private CustomerIdSequenceRepo customerIdSequenceRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerById() {
        int customerId = 1;
        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);

        when(customerRepo.findById(customerId)).thenReturn(customer);

        CustomerEntity result = customerService.getCustomerById(customerId);

        // Perform assertions to verify the result
        // For example:
        // assertEquals(customerId, result.getId());
    }

    @Test
    public void testGetAllCustomers() {
        List<CustomerEntity> customers = new ArrayList<>();
        // Add some test customer entities to the list

        when(customerRepo.findAll()).thenReturn(customers);

        List<CustomerEntity> result = customerService.getAllCustomers();

        // Perform assertions to verify the result
        // For example:
        // assertEquals(customers.size(), result.size());
    }

    @Test
    public void testCreateCustomer() {
        CustomerEntity customer = new CustomerEntity();

        CustomerIdSequence sequence = new CustomerIdSequence();
        sequence.setNextId(1);

        when(customerIdSequenceRepo.findById(1)).thenReturn(Optional.of(sequence));
        when(customerIdSequenceRepo.save(sequence)).thenReturn(sequence);
        when(customerRepo.save(customer)).thenReturn(customer);


        // Perform assertions to verify the result
        // For example:
        // assertEquals(1, result.getId());
    }

    @Test
    public void testUpdateCustomer() {
        // Prepare a test customer entity and mock repository behavior
        CustomerEntity customer = new CustomerEntity();

        customerService.updateCustomer(customer);

        // Verify that the update operation is performed as expected
        // For example, you can use Mockito.verify to ensure the save method is called.
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 1;
        CustomerEntity customer = new CustomerEntity();
        customer.setId(customerId);

        when(customerRepo.findById(customerId)).thenReturn(customer);

        customerService.deleteCustomer(customerId);

        // Verify that the customerRepo.deleteById method is called and the sequence is updated as expected
    }
}
