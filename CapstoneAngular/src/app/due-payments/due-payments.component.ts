import { Component } from '@angular/core';
import { DunningServiceService } from '../dunning-service.service';
import { Duepayments } from '../duepayments';

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


}
