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
  newCustomer: Customer = {
    id: 0, // You may need to set the appropriate default values or leave them as-is
    name: '',
    mailId: '',
    phoneNumber: ''
  };  constructor( private dunningService: DunningServiceService, private router:Router){}
      
  ngOnInit(){
    this.dunningService.customers().subscribe(res => {
      // console.log(res);
      this.Customers= res;
    });
  }
  
  paymentDues(){
    this.router.navigate(['due-payments']);
  }
  addCustomer(customer: Customer) {
    this.dunningService.addCustomer(customer).subscribe((addedCustomer) => {
      console.log('Customer added:', addedCustomer);
    });
  }
  
  
  deleteCustomer(customerId: number) {
    this.dunningService.deleteCustomer(customerId).subscribe(() => {
      this.Customers = this.Customers.filter((customer) => customer.id !== customerId);
    });
  }
  PaymentDetails(){
    
  }
}
