import { Component } from '@angular/core';
import { DunningProcessService } from '../dunning-process.service';
import { CompletedPayments } from '../completed-payments';

@Component({
  selector: 'app-completedpayments',
  templateUrl: './completedpayments.component.html',
  styleUrls: ['./completedpayments.component.css']
})
export class CompletedpaymentsComponent {

payments:CompletedPayments[]=[];

constructor(private dunningService: DunningProcessService){}

  ngOnInit(){
    this.completedreminders();
  }

  completedreminders(){
    this.dunningService.completedPayments().subscribe(res => {
      console.log(res);
      this.payments= res;
    });;
  }
}
