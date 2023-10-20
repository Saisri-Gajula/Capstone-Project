// package com.capstone.collectionprocesshandling.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;

// @Service
// public class ReminderService {

//     // @Autowired
//     // private ReminderService reminderservice;
//     @Value("${spring.twilio.account_sid}")
//     private String twilioAccountSid;

//     @Value("${spring.twilio.auth_token}")
//     private String twilioAuthToken;

//     @Value("${spring.twilio.from_number}")
//     private String twilioPhoneNumber;

//     public boolean sendReminder(String phoneNumber) {
//         // Initialize Twilio client with your credentials
//         Twilio.init(twilioAccountSid, twilioAuthToken);
//         System.out.println("---" + phoneNumber);
//         System.out.println(twilioAccountSid);
//         System.out.println(twilioAccountSid);
        
//         Message message = Message.creator(
//                 new PhoneNumber("whatsapp:" + phoneNumber),
//                 new PhoneNumber("whatsapp:" + twilioPhoneNumber),
//                 "Your payment is due soon. Please make the payment."
//         ).create();

//         return message.getStatus() == Message.Status.SENT;
//     }
//     private final String fromPhoneNumber = "+12296336525";

//     public void sendReminderSms(String phoneNumber) {
//         Twilio.init(twilioAccountSid, twilioAuthToken);

//         try {
//             // Replace the message with your reminder content
//             Message message = Message.creator(
//                 new PhoneNumber(phoneNumber),
//                 new PhoneNumber(fromPhoneNumber),
//                 "Your reminder message here"
//             ).create();

//             System.out.println("Reminder SMS sent: " + message.getSid());
//         } catch (Exception e) {
//             System.err.println("Error sending reminder SMS: " + e.getMessage());
//         }
//     }
// }

