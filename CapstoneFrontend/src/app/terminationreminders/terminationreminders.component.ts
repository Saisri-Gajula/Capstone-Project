import { Component } from '@angular/core';
import { Reminders } from '../reminders';
import { DunningProcessService } from '../dunning-process.service';

@Component({
  selector: 'app-terminationreminders',
  templateUrl: './terminationreminders.component.html',
  styleUrls: ['./terminationreminders.component.css']
})
export class TerminationremindersComponent {
  reminders:Reminders[]=[];
  constructor(private dunningService: DunningProcessService){}
  

   
  ngOnInit(){
    this.terminationreminders();
  }
  terminationreminders(){
    this.dunningService.terminationreminers().subscribe(res => {
      console.log(res);
      this.reminders= res;
    });
  }
  paidCustomers(phoneNumber: string){
    console.log("done payment");
    this.dunningService.paidCustomer(phoneNumber).subscribe((response) => {
      this.reminders = this.reminders.filter((customer) => customer.phoneNumber !== phoneNumber);
      console.log('Payment successfully:', response);
      alert('Payment successfully. You got your services back.');
    }
    );
  }
}
