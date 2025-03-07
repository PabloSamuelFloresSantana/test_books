import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';

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

  returnLoan(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`)
  }
}
