import { Component } from '@angular/core';
import { Customer } from '../customer';
import { DunningProcessService } from '../dunning-process.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  Customers: Customer[]=[];
  newCustomer: Customer = {
    id: 0, // You may need to set the appropriate default values or leave them as-is
    name: '',
    mailId: '',
    phoneNumber: '',
    amount:0,
   
  };  constructor( private dunningService: DunningProcessService, private router:Router){}

  ngOnInit(){

  }
  addCustomer(customer: Customer) {
    this.dunningService.addCustomer(customer).subscribe((addedCustomer) => {
      console.log('Customer added:', addedCustomer);
    });
    this.router.navigate(['customer']);
  }
}
