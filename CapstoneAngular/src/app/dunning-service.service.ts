import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';
@Injectable({
  providedIn: 'root'
})
export class DunningServiceService {
  constructor(private _http:HttpClient) { }

  customers(): Observable<Customer[]> {
    return this._http.get<Customer[]>('http://localhost:8080/api/customers');
    // throw new Error('Method not implemented.');
  }

  


}