// package com.capstone.collectionprocesshandling.service;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.twilio.http.TwilioRestClient;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;

// @Service
// public class TwilioService {
//     private final TwilioRestClient twilioRestClient;

//     public TwilioService(@Value("${twilio.accountSid}") String accountSid,
//                          @Value("${twilio.authToken}") String authToken) {
//         this.twilioRestClient = new TwilioRestClient.Builder(accountSid, authToken).build();
//     }

//     public void sendSms(String to, String message) {
//         Message.creator(new PhoneNumber(to), new PhoneNumber("your Twilio phone number"), message)
//                 .create();
//     }
// }
