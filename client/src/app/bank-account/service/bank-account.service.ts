import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpResponse} from '@angular/common/http';
import { IAccount } from '../model/account.model';
import { Observable } from 'rxjs';

@Injectable()
export class BankAccountService {

  constructor(protected http: HttpClient) { }

  public deposit(amount: number): Observable<HttpResponse<any>> {
    return this.http.post<any>(`http://localhost:8080/operation/deposit`, { amount: amount }, {headers : new HttpHeaders({ 'Content-Type': 'application/json' })});
  }

  public withdrawal(amount: number): Observable<HttpResponse<any>> {
    return this.http.post<any>(`http://localhost:8080/operation/withdrawal`, { amount: amount }, {headers : new HttpHeaders({ 'Content-Type': 'application/json' })});
  }

  public getAllOpetations(): Observable<IAccount[]> {
    return this.http.get<IAccount[]>(`http://localhost:8080/operation/`, {observe: 'body'});
  }

}
