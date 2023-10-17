import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { DuePaymentsComponent } from './due-payments/due-payments.component';






@NgModule({
 
  declarations: [
    AppComponent,
    CustomerComponent,
    DuePaymentsComponent
  ],
  imports:[
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
