import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Loan } from '../models/loan.interface';

@Injectable({
  providedIn: 'root'
})
export class LoanService {
  private apiUrl = "http://localhost:8080/api/test/loans"
  http = inject(HttpClient)

  constructor() { }

  getLoans(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl)
  }

  createLoan(loan: Loan): Observable<string> {
    return this.http.post<string>(this.apiUrl, loan)
  }

  returnLoan(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`)
  }
}
