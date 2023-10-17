import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DuePaymentsComponent } from './due-payments/due-payments.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  {path: '', component:CustomerComponent },
  { path: 'due-payments', component: DuePaymentsComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
