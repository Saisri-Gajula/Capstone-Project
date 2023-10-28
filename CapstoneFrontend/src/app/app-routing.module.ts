import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { DuePaymentsComponent } from './due-payments/due-payments.component';
import { CuringComponent } from './curing/curing.component';
import { FirstremindersComponent } from './firstreminders/firstreminders.component';
import { SecondremindersComponent } from './secondreminders/secondreminders.component';
import { TerminationremindersComponent } from './terminationreminders/terminationreminders.component';

const routes: Routes = [
  { path: 'customer', component: CustomerComponent },
  { path: 'due-payments', component: DuePaymentsComponent },
  { path: 'firstreminders', component: FirstremindersComponent },
  { path: 'secondreminders', component: SecondremindersComponent },
  { path: 'terminationreminders', component: TerminationremindersComponent },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
