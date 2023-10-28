// import { Component } from '@angular/core';
// import { DunningProcessService } from '../dunning-process.service';
// import { Customer } from '../customer';
// import { DayInstance } from 'twilio/lib/rest/bulkexports/v1/export/day';

// @Component({
//   selector: 'app-login',
//   templateUrl: './login.component.html',
//   styleUrls: ['./login.component.css']
// })
// export class LoginComponent {
//   newCustomer: Customer = {
//     id: 0, // You may need to set the appropriate default values or leave them as-is
//     name: '',
//     mailId: '',
//     phoneNumber: '',
//     days: 0,
//     paymentPlan:'',
//   };   constructor( private dunningService: DunningProcessService){}
//   addCustomer(customer: Customer) {
//     this.dunningService.addCustomer(customer).subscribe((addedCustomer) => {

//       console.log('Customer added:', addedCustomer);
//     });

//   }
  
// }
