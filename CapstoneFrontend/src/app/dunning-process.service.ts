import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { DuePayments } from './due-payments';
import { HttpClient } from '@angular/common/http';

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
    return this._http.get(`${'http://localhost:8080/api/send-sms'}/${phoneNumber}`); // Use GET since it's a reminder
  }

}
