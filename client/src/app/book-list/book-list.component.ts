import { Component, inject } from '@angular/core';
import { BookService } from '../services/book.service';
import { Router } from '@angular/router';
import { Book } from '../models/book.interface';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent {
  bookService = inject(BookService)
  router = inject(Router)
  books: Book[] = []

  ngOnInit() {
    this.bookService
      .getBooks()
      .subscribe((data) => (this.books = data))
  }

  goToCreate() {
    this.router.navigate(["/create-book"])
  }

  editBook(id: number) {
    this.router.navigate(["/edit-book", id])
  }

  deleteBook(id: number) {
    if (confirm("¿Estás seguro de eliminar este libro?")) {
      this.bookService.deleteBook(id).subscribe(() => {
        this.books = this.books.filter((b) => b.id != id)
      })
    }
  }
}
