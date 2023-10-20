import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { DuePaymentsComponent } from './due-payments/due-payments.component';
import { Duepayments } from './duepayments';
@Injectable({
  providedIn: 'root'
})
export class DunningServiceService {
  constructor(private _http:HttpClient) { }

  customers(): Observable<Customer[]> {
    return this._http.get<Customer[]>('http://localhost:8080/api/customers');
    // throw new Error('Method not implemented.');
  }

  duePayments(): Observable<Duepayments[]>{
    return this._http.get<Duepayments[]>('http://localhost:8080/api/dunningPays');
  }
  
  addCustomer(customer: Customer): Observable<Customer[]> {
    return this._http.post<Customer[]>('http://localhost:8080/api/add-customer', customer);
  }

  
  deleteCustomer(customerId: number): Observable<void> {
    return this._http.delete<void>(`${'http://localhost:8080/api'}/${customerId}`);
  }

  
  sendReminder(phoneNumber : string): Observable<any> {
    console.log("phonenumber:"+phoneNumber)
    return this._http.post<any>('http://localhost:8080/api/send-reminder',phoneNumber);
  }


  
  sendSMSReminder(phoneNumber: string) {
  
    return this._http.post('http://localhost:8080/api/send-reminder', phoneNumber);
  }
}
