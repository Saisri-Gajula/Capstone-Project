import { Component } from '@angular/core';
import { DunningServiceService } from '../dunning-service.service';
import { Customer } from '../customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent {
  Customers: Customer[]=[];
 
  constructor( private dunningService: DunningServiceService, private router:Router){}
      
  ngOnInit(){
    this.dunningService.customers().subscribe(res => {
      console.log(res);
      this.Customers= res;
    });
  }
  
  paymentDues(id: number){
    this.router.navigate(['due-payments', id]);
  }
  
}
