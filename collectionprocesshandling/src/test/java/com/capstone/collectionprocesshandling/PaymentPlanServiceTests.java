package com.capstone.collectionprocesshandling;
import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.PaymentPlanEntity;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.PaymentPlanRepo;
import com.capstone.collectionprocesshandling.service.PaymentPlanService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentPlanServiceTests {

    @InjectMocks
    private PaymentPlanService paymentPlanService;

    @Mock
    private PaymentPlanRepo paymentPlanRepo;

    @Mock
    private CustomerRepo customerRepo;

    @BeforeEach
    void setUp() {
        // Initialize Mockito annotations
        MockitoAnnotations.openMocks(this);
    }
@Test
void testAddCustomerToPaymentPlan() {
    // Create a sample customer ID, paid amount, and due amount
    int customerId = 1;
    int paidAmount = 100;
    int dueAmount = 500;
    LocalDate dueDate;

    // Create a sample CustomerEntity
    CustomerEntity customer = new CustomerEntity();

    // Create a sample PaymentPlanEntity object to be returned by the repository
    PaymentPlanEntity expectedPaymentPlan = new PaymentPlanEntity();
    expectedPaymentPlan.setDueamount(dueAmount);
    expectedPaymentPlan.setPaidmaount(paidAmount);
    expectedPaymentPlan.setDuedate(LocalDate.now().plusDays(30));

    // Mock the behavior of customerRepo to return an Optional with the customer
    Mockito.when(customerRepo.findById(customerId)).thenReturn(customer);

    // Mock the behavior of paymentPlanRepo to return the expectedPaymentPlan when save is called
    Mockito.when(paymentPlanRepo.save(Mockito.any(PaymentPlanEntity.class))).thenReturn(expectedPaymentPlan);

    // Call the method to be tested
    // PaymentPlanEntity result = paymentPlanService.addCustomerToPaymentPlan(customerId, paidAmount, dueAmount);

    // Verify that the expected PaymentPlanEntity was returned
    // assertEquals(expectedPaymentPlan, result);
}

}
