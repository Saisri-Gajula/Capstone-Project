// package com.capstone.collectionprocesshandling;
// import com.capstone.collectionprocesshandling.controller.Smsrequest;
// import com.capstone.collectionprocesshandling.service.ReminderService;
// import com.capstone.collectionprocesshandling.service.Twilioinitializer;
// import com.capstone.collectionprocesshandling.service.Twilioproperties;
// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;
// import org.junit.jupiter.api.BeforeEach;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.ResponseEntity;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;
// @SpringBootTest
// public class ReminderServiceTests {
//     @InjectMocks
//     private ReminderService reminderService;

//     @Mock
//     private Message message;

//     @Mock
//     private Twilioproperties twilioproperties;

//     @MockBean
//     private Twilioinitializer twilioInitializer;


//     @Value("${twilio.account_sid}")
//     private String twilioAccountSid;

//     @Value("${twilio.auth_token}")
//     private String twilioAuthToken;

//     @Value("${twilio.from_number}")
//     private String twilioPhoneNumber;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.initMocks(this);
//         reminderService = new ReminderService(twilioproperties);
//     }

//     @org.junit.jupiter.api.Test
//     public void testSendReminderSms() {
//         // Arrange
//         Smsrequest smsrequest = new Smsrequest("+917660842840", "Test message");
//         String expectedStatus = "SENT";
        
//         // Mock TwilioInitializer's behavior
//         when(twilioInitializer.someMethod()).thenReturn(10);
        
//         // Mock Twilioproperties to return the 'fromNumber' you expect
//         when(twilioproperties.getFromNumber()).thenReturn("your_twilio_phone_number");
        
//         // Mock Message.creator
//         Twilio.init("ACcc86f0beae31ed1b268f47aa911b229a", "e54916266d3411d88d4cccad16132e05");

//         Message message2 = Message.creator(new PhoneNumber(smsrequest.getNumber()),  // Recipient's phone number
//         new PhoneNumber("+12296336525"),
//         "Hi Saisri" ).create();

//         when(message.getStatus()).thenReturn(Message.Status.SENT);
        
//         // Mock Twilio.init
        

//         when(message.creator(new PhoneNumber(smsrequest.getNumber()), new PhoneNumber("+12296336525"), "hi crack").create()).thenReturn(message2);

//         // Act
//         String result = reminderService.sendReminderSms(smsrequest);

//         // Assert
//         assertEquals(expectedStatus, result);
//     }
// }
