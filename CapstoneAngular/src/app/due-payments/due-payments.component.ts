import { Component } from '@angular/core';
import { DunningServiceService } from '../dunning-service.service';
import { Duepayments } from '../duepayments';
import { Message } from 'twilio/lib/twiml/MessagingResponse';

@Component({
  selector: 'app-due-payments',
  templateUrl: './due-payments.component.html',
  styleUrls: ['./due-payments.component.css']
})
export class DuePaymentsComponent {

constructor(private dunningService: DunningServiceService){}
duepayment: Duepayments[]=[];
 
  ngOnInit(){
    console.log("here");
    this.getdunpayments();

  }

  getdunpayments(){
    this.dunningService.duePayments().subscribe(res => {
      console.log(res);
      this.duepayment= res;
    });
    
  }

  
  sendReminder(PhoneNumber: string) {


  //   if (!PhoneNumber.startsWith('whatsapp:')) {
  //     PhoneNumber = 'whatsapp:' + PhoneNumber;
  // }
  
    this.dunningService.sendReminder(PhoneNumber).subscribe(
      response => {
        console.log('Reminder sent successfully:', response);
      },
      error => {
        console.error('Error sending reminder:', error);
      }
    );
  }
  
  sendsmsReminder(phoneNumber: string) {
    this.dunningService.sendSMSReminder(phoneNumber).subscribe(
        (response) => {
            console.log('Reminder sent successfully');
        },
        (error) => {
            console.error('Error sending reminder:', error);
        }
    );
}
  
}
