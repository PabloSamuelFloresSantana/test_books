import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../models/book.interface';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = "http://localhost:8080/api/test/books"
  http = inject(HttpClient)

  constructor() { }

  getBooks(): Observable<Book[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getBook(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.apiUrl}/${id}`)
  }

  createBook(book: Book): Observable<string> {
    return this.http.post<string>(this.apiUrl, book)
  }

  updateBook(book: Book): Observable<string> {
    return this.http.put<string>(this.apiUrl, book)
  }

  deleteBook(id: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/${id}`)
  }
}
