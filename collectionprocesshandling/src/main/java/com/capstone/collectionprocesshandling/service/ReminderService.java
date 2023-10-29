package com.capstone.collectionprocesshandling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.capstone.collectionprocesshandling.controller.Smsrequest;
import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.FirstReminderRequest;
import com.capstone.collectionprocesshandling.model.SecondReminderRequest;
import com.capstone.collectionprocesshandling.model.TerminationReminderRequest;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.repository.FirstReminderRepo;
import com.capstone.collectionprocesshandling.repository.SecondreminderRepo;
import com.capstone.collectionprocesshandling.repository.TerminationReminderRepo;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

@Service
public class ReminderService {

    @Autowired
    private Smsrequest smsrequest;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private DunningRepo dunningRepo;

    @Autowired
    private FirstReminderRepo firstreminderRepo;
    
    @Autowired
    private SecondreminderRepo secondreminderRepo;

    @Autowired
    private TerminationReminderRepo terminationreminderRepo;
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


    public String sendReminderSms(String phoneNumber,String name,int reminderLevel) {

        smsrequest.setNumber(phoneNumber);
        smsrequest.setMessage("Hi " +name+"! This is from purchasing app. You have due payments on purchased products. Please complete your payments. Otherwise We are going to terminate your account (or) Cancel your access to this products.");
    
        Twilio.init(twilioAccountSid, twilioAuthToken);
        System.out.println(smsrequest.getNumber());
            Message message = Message.creator(
                new PhoneNumber(smsrequest.getNumber()),  // Recipient's phone number
                new PhoneNumber(twilioproperties.getFromNumber()),
                smsrequest.getMessage()  // Message content
            ).create();
            if(reminderLevel==1){
                FirstReminderRequest firstreminder = new FirstReminderRequest();
                firstreminder.setPhoneNumber(smsrequest.getNumber());
                firstreminder.setReminderLevel(reminderLevel);
                firstreminder.setDueamount(2500);
                firstreminder.setDueDate(dunningRepo.findByCustomerId(customerRepo.findByPhoneNumber(phoneNumber).getId()).getDueDate());
                firstreminder.setCustomer(customerRepo.findByPhoneNumber(phoneNumber));
                firstreminderRepo.save(firstreminder);
            }
            else if(reminderLevel==2){
                 SecondReminderRequest secondreminder = new SecondReminderRequest();
                secondreminder.setPhoneNumber(smsrequest.getNumber());
                secondreminder.setReminderLevel(reminderLevel);
                secondreminder.setDueamount(2500);
                secondreminder.setDueDate(dunningRepo.findByCustomerId(customerRepo.findByPhoneNumber(phoneNumber).getId()).getDueDate());
                secondreminder.setCustomer(customerRepo.findByPhoneNumber(phoneNumber));
                secondreminderRepo.save(secondreminder);
            }
            else if(reminderLevel==3){
                 TerminationReminderRequest terminationreminder = new TerminationReminderRequest();
                 CustomerEntity customer = new CustomerEntity();
                terminationreminder.setPhoneNumber(smsrequest.getNumber());
                terminationreminder.setReminderLevel(reminderLevel);
                terminationreminder.setDueamount(2500);
                terminationreminder.setDueDate(dunningRepo.findByCustomerId(customerRepo.findByPhoneNumber(phoneNumber).getId()).getDueDate());
                terminationreminder.setCustomer(customerRepo.findByPhoneNumber(phoneNumber));
                terminationreminderRepo.save(terminationreminder);
                
            }

           return message.getStatus().toString();
    }


    public List<FirstReminderRequest> firstReminders(){
        return firstreminderRepo.findAll();
    }

    public List<SecondReminderRequest> secondreminders(){
        return secondreminderRepo.findAll();
    }

    public List<TerminationReminderRequest> terminationReminders(){
        return terminationreminderRepo.findAll();
    }

    public List<FirstReminderRequest> curingreminders(){
       return  firstreminderRepo.findAll();
    }
}
