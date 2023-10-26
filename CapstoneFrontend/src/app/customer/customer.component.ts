import { Component } from '@angular/core';
import { Customer } from '../customer';
import { DunningProcessService } from '../dunning-process.service';
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
    phoneNumber: '',
    dueDate: new Date(),
    Product:''
  };  constructor( private dunningService: DunningProcessService, private router:Router){}
      
  ngOnInit(){
    this.dunningService.customers().subscribe(res => {
      console.log(res);
      this.Customers= res;
    });
  }
  
  paymentDues(){
    console.log("-----------Hey this is paymentduesMethod");
    this.router.navigate(['app-due-payments']);
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
