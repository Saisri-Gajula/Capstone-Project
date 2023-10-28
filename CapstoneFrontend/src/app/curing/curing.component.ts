import { Component } from '@angular/core';
import { Reminders } from '../reminders';
import { DunningProcessService } from '../dunning-process.service';

@Component({
  selector: 'app-curing',
  templateUrl: './curing.component.html',
  styleUrls: ['./curing.component.css']
})
export class CuringComponent {

reminders: Reminders[]=[];

constructor(private dunningService:DunningProcessService){}


ngOnInit(){
  this.payment();
}
  payment(){
    console.log("here");
    this.dunningService.curingreminders().subscribe(res => {
      console.log(res);
      this.reminders= res;
    });;
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
