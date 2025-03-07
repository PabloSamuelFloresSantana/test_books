import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BookService } from '../services/book.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent {
  bookForm: FormGroup;
  isEdit = false;
  bookId: number | null = null;
  submitted = false;

  // Servicios
  fb = inject(FormBuilder);
  bookService = inject(BookService);
  router = inject(Router);
  route = inject(ActivatedRoute);

  constructor() {
    this.bookForm = this.fb.group({
      title: ["", [Validators.required, Validators.maxLength(200)]],
      synopsis: ["", [Validators.required, Validators.minLength(20)]],
      publicationDate: ["", Validators.required],
      authors: ["", [Validators.required, Validators.maxLength(300)]],
      publishers: ["", [Validators.required, Validators.maxLength(200)]],
      totalStock: [0, [Validators.required, Validators.min(0)]],
      currentStock: [0, [Validators.required, Validators.min(0)]]
    });
  }

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      const id = params.get("id");
      if (id) {
        this.isEdit = true;
        this.bookId = Number(id);
        this.bookService.getBook(this.bookId).subscribe({
          next: (data) => this.bookForm.patchValue(data),
          error: () => this.router.navigate(['/'])
        });
      }
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.bookForm.invalid) return;

    const bookData = this.bookForm.value;
    
    const operation = this.isEdit && this.bookId
      ? this.bookService.updateBook({ ...bookData, id: this.bookId })
      : this.bookService.createBook(bookData);

    operation.subscribe({
      next: () => this.router.navigate(["/"]),
      error: (error) => console.error('Error:', error)
    });
  }

  // Helper para acceder a los controles del formulario
  get f() {
    return this.bookForm.controls;
  }
}
