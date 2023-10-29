package com.capstone.collectionprocesshandling;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.model.PaymentHistory;
import com.capstone.collectionprocesshandling.model.SecondReminderRequest;
import com.capstone.collectionprocesshandling.model.TerminationReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;
import com.capstone.collectionprocesshandling.repository.PaymentHistoryRepo;
import com.capstone.collectionprocesshandling.repository.SecondreminderRepo;
import com.capstone.collectionprocesshandling.repository.TerminationReminderRepo;
import com.capstone.collectionprocesshandling.service.PaymentHistoryService;
@SpringBootTest
public class PaymentHistoryServiceTests {

    @InjectMocks
    private PaymentHistoryService paymentHistoryService;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private TerminationReminderRepo terminationReminderRepo;

    @Mock
    private SecondreminderRepo secondReminderRepo;

    @Mock
    private FirstReminderRepo firstReminderRepo;

    @Mock
    private PaymentHistoryRepo paymentHistoryRepo;

    @Mock
    private DunningRepo dunningRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaidCustomer() {
        // Create a sample customer and other related objects
        CustomerEntity customer = new CustomerEntity();
        customer.setPhoneNumber("1234567890");

        TerminationReminderRequest terminationReminder = new TerminationReminderRequest();
        terminationReminder.setPhoneNumber("1234567890");

        SecondReminderRequest secondReminder = new SecondReminderRequest();
        secondReminder.setPhoneNumber("1234567890");

        FirstReminderRequest firstReminder = new FirstReminderRequest();
        firstReminder.setPhoneNumber("1234567890");

        DunningEntity dunningEntity = new DunningEntity();
        dunningEntity.setCustomer(customer);

        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setPhoneNumber("1234567890");
        paymentHistory.setCustomer(customer);
        paymentHistory.setStatus("paid");
        paymentHistory.setDate(new Date());
        paymentHistory.setTotalamount(5000);

        // Mock repository methods
        when(customerRepo.findByPhoneNumber("1234567890")).thenReturn(customer);
        when(terminationReminderRepo.findByPhoneNumber("1234567890")).thenReturn(terminationReminder);
        when(secondReminderRepo.findByPhoneNumber("1234567890")).thenReturn(secondReminder);
        when(firstReminderRepo.findByPhoneNumber("1234567890")).thenReturn(firstReminder);
        when(dunningRepo.findByCustomerId(customer.getId())).thenReturn(dunningEntity);

        // Call the method
        paymentHistoryService.paidCustomer("1234567890");

        // Verify interactions with the repositories
        // verify(paymentHistoryRepo).save(paymentHistory);
        verify(terminationReminderRepo).delete(terminationReminder);
        verify(secondReminderRepo).delete(secondReminder);
        verify(firstReminderRepo).delete(firstReminder);
        verify(dunningRepo).delete(dunningEntity);

        // Perform assertions, e.g., verify that the customer's reminders and dunning were deleted correctly
    }
}
