package com.capstone.collectionprocesshandling.controller;
// package com.capstone.collectionprocesshandling.Controller;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;

// import com.twilio.exception.ApiException;



// @Controller
// public class TwilioController {

// 	@Autowired
//    private smsservice smsservice;
	    
// 	@RequestMapping("/")
// 	public String homepage(ModelAndView model)
// 	{
// 		return "index";
// 	}
	
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
   
	
	
// }