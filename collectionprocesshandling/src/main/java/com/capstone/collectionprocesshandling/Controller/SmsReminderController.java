// package com.capstone.collectionprocesshandling.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.capstone.collectionprocesshandling.service.ReminderService;
// import com.capstone.collectionprocesshandling.service.customerService;



// @RestController
// @RequestMapping("/api/reminders")
// public class SmsReminderController {

//     @Autowired
//     private ReminderService reminderservice;
//     @Autowired
//     private customerService customerservice;
    
//     // @Autowired
//     // public SmsReminderController(ReminderService reminderService) {
//     //     this.reminderservice = reminderService;
//     // }
    
//     @PostMapping("/send")
//     public ResponseEntity<String> sendReminderSms(@RequestParam String phoneNumber) {
//         reminderservice.sendReminderSms(phoneNumber);
//         return ResponseEntity.ok("Reminder sent successfully");
//     }
// }
