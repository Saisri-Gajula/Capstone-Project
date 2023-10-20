// package com.capstone.collectionprocesshandling.Controller;

// import org.apache.http.HttpStatus;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.capstone.collectionprocesshandling.Model.ReminderRequest;
// import com.capstone.collectionprocesshandling.service.ReminderService;

// @RestController
// @RequestMapping("/api")
// @CrossOrigin(origins = "*")
// public class ReminderController {

//     @Autowired
//     private ReminderService reminderService;

//     @PostMapping("/send-reminder")
//     public ResponseEntity<String> sendReminder(@RequestBody String request) {
//         System.out.println("------------------------------------------------------------"+request);
//         boolean sent = reminderService.sendReminder(request);

//         if (sent) {
//             return ResponseEntity.ok("Reminder sent successfully");
//         } else {
//             return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Failed to send reminder");
//         }
//     }
// }
