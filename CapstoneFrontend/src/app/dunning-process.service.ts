import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { DuePayments } from './due-payments';
import { HttpClient } from '@angular/common/http';
import { Reminders } from './reminders';
import { CompletedPayments } from './completed-payments';
import { Paymentplan } from './paymentplan';

@Injectable({
  providedIn: 'root'
})
export class DunningProcessService {


  constructor(private _http:HttpClient) { }

  customers(): Observable<Customer[]> {
    return this._http.get<Customer[]>('http://localhost:8080/api/customers');
    // throw new Error('Method not implemented.');
  }

  duePayments(): Observable<DuePayments[]>{
    return this._http.get<DuePayments[]>('http://localhost:8080/api/dunningPays');
  }
  
  addCustomer(customer: Customer): Observable<Customer[]> {
    return this._http.post<Customer[]>('http://localhost:8080/api/add-customer', customer);
  }

  
  deleteCustomer(customerId: number): Observable<void> {
    return this._http.delete<void>(`${'http://localhost:8080/api'}/${customerId}`);
  }


  sendReminderSms(phoneNumber: string): Observable<any> {
    return this._http.get(`${'http://localhost:8080/api/send-sms'}/${phoneNumber}`, { responseType: 'text' }); // Use GET since it's a reminder
  }

  paidCustomer(phoneNumber: string): Observable<any>{
    return this._http.get(`${'http://localhost:8080/api/add-payment'}/${phoneNumber}`, { responseType: 'text' });
  }

  curingreminders(): Observable<Reminders[]>{
    return this._http.get<Reminders[]>('http://localhost:8080/api/curing');
  }

  
  firstreminders(): Observable<Reminders[]>{
    return this._http.get<Reminders[]>('http://localhost:8080/api/initialReminders');
  }

  
  secondreminders(): Observable<Reminders[]>{
    return this._http.get<Reminders[]>('http://localhost:8080/api/secondReminders');
  }

  
  terminationreminers(): Observable<Reminders[]>{
    return this._http.get<Reminders[]>('http://localhost:8080/api/terminationReminders');
  }

  completedPayments(): Observable<CompletedPayments[]>{
    return this._http.get<CompletedPayments[]>('http://localhost:8080/api/completedPayments');
  }
  addCustomerToPaymentPlan(customerId: number, paidAmount: number, dueAmount: number): Observable<Paymentplan[]> {
    console.log(paidAmount);
    console.log(dueAmount);
    const url = `http://localhost:8080/api/paymentplan/${customerId}/${paidAmount}/${dueAmount}`;
    return this._http.post<Paymentplan[]>(url, null);
  }
  
}
