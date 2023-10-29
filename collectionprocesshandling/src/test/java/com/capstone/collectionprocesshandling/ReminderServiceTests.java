package com.capstone.collectionprocesshandling;
import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;
import com.capstone.collectionprocesshandling.repository.SecondreminderRepo;
import com.capstone.collectionprocesshandling.repository.TerminationReminderRepo;
import com.capstone.collectionprocesshandling.service.ReminderService;
import com.capstone.collectionprocesshandling.service.Twilioproperties;
import com.twilio.Twilio;
import com.capstone.collectionprocesshandling.controller.Smsrequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
@SpringBootTest
class ReminderServiceTests {

    @InjectMocks
    private ReminderService reminderService;

    @Mock
    private Smsrequest smsrequest;

    @Mock
    private CustomerRepo customerRepo;

    @Mock
    private DunningRepo dunningRepo;

    @Mock
    private FirstReminderRepo firstreminderRepo;

    @Mock
    private SecondreminderRepo secondreminderRepo;

    @Mock
    private TerminationReminderRepo terminationreminderRepo;

    @Mock
    private Twilioproperties twilioproperties;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock Twilio properties
        when(twilioproperties.getFromNumber()).thenReturn("+18647131254");

        // Initialize the Twilio client with dummy credentials
        Twilio.init("ACc2bac07de5e7fbea4b59079daf2a732b", "8a1cf8632b16f1ee94492a3098441e14");
    }
@Test
void testSendReminderSmsFirstReminder() {
    // Mock data and dependencies
    String phoneNumber = "1234567890";
    String name = "John";
    int reminderLevel = 1;
    CustomerEntity customer = new CustomerEntity();
    DunningEntity dunningEntity = new DunningEntity();
    dunningEntity.setDueDate(LocalDate.now()); // Set a due date

    when(smsrequest.getNumber()).thenReturn(phoneNumber);
    when(customerRepo.findByPhoneNumber(phoneNumber)).thenReturn(customer);
    when(dunningRepo.findByCustomerId(customer.getId())).thenReturn(dunningEntity);

    // Call the method to be tested
    // String result = reminderService.sendReminderSms(phoneNumber, name, reminderLevel);

    // Verify the result
    // assertEquals("messageSid", result); // Replace "messageSid" with the expected message SID
}

// @Test
// void testSendReminderSmsSecondReminder() {
//     // Implement this test case similarly to the first reminder test case
// }

// @Test
// void testSendReminderSmsTerminationReminder() {
//     // Implement this test case for the termination reminder
// }

@Test
void testSendReminderSmsInvalidReminderLevel() {
    // Mock data and dependencies
    String phoneNumber = "1234567890";
    String name = "John";
    int reminderLevel = 4; // Invalid reminder level

    // Call the method to be tested
    // String result = reminderService.sendReminderSms(phoneNumber, name, reminderLevel);

    // Verify the result
    // assertEquals("invalidReminderLeqqqvel", result); // Replace "invalidReminderLevel" with the expected result for an invalid reminder level
}

@Test
void testFirstReminders() {
    // Mock data for first reminder list
    FirstReminderRequest firstReminder1 = new FirstReminderRequest();
    FirstReminderRequest firstReminder2 = new FirstReminderRequest();

    when(firstreminderRepo.findAll()).thenReturn(List.of(firstReminder1, firstReminder2));

    // Call the method to be tested
    List<FirstReminderRequest> result = reminderService.firstReminders();

    // Verify the result
    assertEquals(2, result.size());
}

// @Test
// void testSecondReminders() {
//     // Implement this test case similarly to the first reminder list test case
// }

// @Test
// void testTerminationReminders() {
//     // Implement this test case for the termination reminder list
// }

// @Test
// void testCuringReminders() {
//     // Implement this test case for the curing reminder list
// }

}
