import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reminders } from '../reminders';
import { DunningProcessService } from '../dunning-process.service';
import { Paymentplan } from '../paymentplan';
import { CustomerComponent } from '../customer/customer.component';
import { Customer } from '../customer';

@Component({
  selector: 'app-paymentactions',
  templateUrl: './paymentactions.component.html',
  styleUrls: ['./paymentactions.component.css']
})
export class PaymentactionsComponent {

  customerId: number | undefined;
 
  paidamount: number | undefined;
  
  reminders:Reminders[]=[];
paymentplan: Paymentplan[]=[];
customerplan: Paymentplan = {
  id: 0, // You may need to set the appropriate default values or leave them as-is
  paidamount: 0,
  dueamount: 0,
  duedate: new Date(), // Set the duedate to a Date object
  customer: {} as Customer, // Initialize customer as an empty Customer object
};

paidAmount = 2500; // Initialize paidAmount
dueAmount=2500;
  installmentAmount=1250;
  constructor(private dunningService: DunningProcessService,private router: Router,private route:ActivatedRoute){}

  ngOnInit(){
    this.route.paramMap.subscribe((params) => {
      const customerIdParam = params.get('customerId');
      if (customerIdParam) {
        this.customerId = +customerIdParam;
        this.loadCustomerReminders();
      }
    });
  }
  paymentplancustomer(customer: Customer) {
    this.dunningService.addCustomer(customer).subscribe((addedCustomer) => {
      console.log('Customer added:', addedCustomer);
    });
    this.router.navigate(['customer']);
  }

  
  loadCustomerReminders() {
    this.dunningService.terminationreminers().subscribe((res) => {
      // Filter reminders for the specific customer ID
      this.reminders = res.filter((reminder) => reminder.customer.id === this.customerId);
    });
  }
  paymentoptions(){
    this.dunningService.terminationreminers().subscribe(res => {
      console.log(res);
      this.reminders= res;
    });
  }
 
  
  installmentpay(customerId: number) {

    this.paidAmount=3750;
    this.dueAmount=1250;
    this.installmentAmount=1250;
    this.dunningService.addCustomerToPaymentPlan(customerId,this.paidAmount,this.dueAmount).subscribe(() => {

    });

  }
}
