package com.capstone.collectionprocesshandling.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.capstone.collectionprocesshandling.controller.Smsrequest;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

@Service
public class ReminderService {
    
    @Value("${twilio.account_sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth_token}")
    private String twilioAuthToken;

    @Value("${twilio.from_number}")
    private String twilioPhoneNumber;

private Twilioproperties twilioproperties;
public ReminderService(Twilioproperties twilioproperties){
this.twilioproperties=twilioproperties;
}


    public String sendReminderSms(Smsrequest smsrequest) {
        Twilio.init(twilioAccountSid, twilioAuthToken);
        System.out.println(smsrequest.getNumber());
       
            Message message = Message.creator(

                new PhoneNumber(smsrequest.getNumber()),  // Recipient's phone number
                new PhoneNumber(twilioproperties.getFromNumber()),
                smsrequest.getMessage()  // Message content
            ).create();
            System.out.println("----------------------------------------"+smsrequest.getNumber());
           return message.getStatus().toString();
    }

}
