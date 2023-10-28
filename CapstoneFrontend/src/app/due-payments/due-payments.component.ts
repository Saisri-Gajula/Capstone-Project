import { Component } from '@angular/core';
import { DuePayments } from '../due-payments';
import { DunningProcessService } from '../dunning-process.service';

@Component({
  selector: 'app-due-payments',
  templateUrl: './due-payments.component.html',
  styleUrls: ['./due-payments.component.css']
})
export class DuePaymentsComponent {
  
constructor(private dunningService: DunningProcessService){}
duepayment: DuePayments[]=[];
 
  ngOnInit(){
    console.log("here");
    this.getdunpayments();

  }
  
  getdunpayments(){
    console.log("am here ------------------------getdunpa");

    this.dunningService.duePayments().subscribe(res => {
      console.log(res);
      this.duepayment= res;
    });
    
  }
  sendReminder(phoneNumber: string) {
    this.dunningService.sendReminderSms(phoneNumber).subscribe(
      (response) => {
        console.log('Reminder sent successfully:', response);
        alert('Reminder is sent successfully.');
      }
     
    );
  }
}
