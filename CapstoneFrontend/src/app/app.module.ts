import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerComponent } from './customer/customer.component';
import { DuePaymentsComponent } from './due-payments/due-payments.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CuringComponent } from './curing/curing.component';
import { FirstremindersComponent } from './firstreminders/firstreminders.component';
import { SecondremindersComponent } from './secondreminders/secondreminders.component';
import { TerminationremindersComponent } from './terminationreminders/terminationreminders.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    DuePaymentsComponent,
    NavbarComponent,
    CuringComponent,
    FirstremindersComponent,
    SecondremindersComponent,
    TerminationremindersComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
