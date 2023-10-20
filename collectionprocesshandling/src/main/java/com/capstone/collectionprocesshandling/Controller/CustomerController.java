package com.capstone.collectionprocesshandling.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.collectionprocesshandling.Model.CustomerEntity;
import com.capstone.collectionprocesshandling.Repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.service.Smsservice;
import com.capstone.collectionprocesshandling.service.customerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private customerService customerservice;
    
    @Autowired
    private CustomerRepo customerRepo;
    // @Autowired
    // private Smsservice smsservice;
        
    // @RequestMapping("/")
    // public String homepage(ModelAndView model)
    // {
    //     return "index";
    // }
    // Use environment variables or other secure methods to store these values
    public static final String ACCOUNT_SID = System.getenv("ACcc86f0beae31ed1b268f47aa911b229a");
    public static final String AUTH_TOKEN = System.getenv("bbd48e50cbbf141214e40f20e702aeb1");
    
    public CustomerController(customerService customerService2) {
    }

    @GetMapping("/customers")
    public List<CustomerEntity> getcustomers(){
        // System.out.println(customerservice.getcustomers());
        // Twilio.init("ACcc86f0beae31ed1b268f47aa911b229a", "bbd48e50cbbf141214e40f20e702aeb1");
        // Message message = Message.creator(
        //         new com.twilio.type.PhoneNumber("whatsapp:+12296336525"),
        //         new com.twilio.type.PhoneNumber("whatsapp:+917660842840"),
        //         "Hello, there!")
        //     .create();

        // System.out.println(message.getSid());
        return customerservice.getcustomers();
    }
    
	
//    @PostMapping("/sendmessage")
//    public ResponseEntity<Object> sendmessage(Smsrequest smsrequest)
//    {
// 	   String status=smsservice.sendsms(smsrequest);
// 	   if("sent".equals(status)||"queued".equals(status))
//        {
//        	return new ResponseEntity<Object>("sent successfully",HttpStatus.OK);
//        }
// 	   return new ResponseEntity<Object>("failed to send message",HttpStatus.NOT_FOUND);
//    }
   

@PostMapping("/add-customer")
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerRepo.save(customer);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int customerId) {
        customerservice.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
