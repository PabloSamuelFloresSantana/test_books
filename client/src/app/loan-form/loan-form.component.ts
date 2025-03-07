import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, AbstractControl, ValidationErrors } from '@angular/forms';
import { LoanService } from '../services/loan.service';
import { BookService } from '../services/book.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Book } from '../models/book.interface';

@Component({
  selector: 'app-loan-form',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './loan-form.component.html',
  styleUrl: './loan-form.component.css'
})
export class LoanFormComponent {
  loanForm: FormGroup;
  submitted = false;
  books: Book[] = [];
  calculatedDueDate: string | null = null;

  // Servicios
  fb = inject(FormBuilder);
  loanService = inject(LoanService);
  bookService = inject(BookService);
  router = inject(Router);

  constructor() {
    this.loanForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.maxLength(200)]],
      bookId: [null, Validators.required],
      loanDate: ['', Validators.required],
      returnDate: ['', Validators.required],  // Fecha límite para devolver
      dueDate: [{value: '', disabled: true}]  // Campo informativo calculado
    }, { validators: this.dateValidator });
  }

  ngOnInit() {
    this.bookService.getBooks().subscribe({
      next: (data) => this.books = data,
      error: (error) => console.error('Error cargando libros:', error)
    });

    // Calcular dueDate cuando cambia returnDate
    this.loanForm.get('returnDate')?.valueChanges.subscribe(returnDate => {
      if (returnDate) {
        const dueDate = new Date(returnDate);
        dueDate.setDate(dueDate.getDate() + 3);
        this.calculatedDueDate = dueDate.toISOString().split('T')[0];
        this.loanForm.patchValue({ dueDate: this.calculatedDueDate });
      }
    });
  }

  private dateValidator(control: AbstractControl): ValidationErrors | null {
    const loanDate = control.get('loanDate')?.value;
    const returnDate = control.get('returnDate')?.value;
    
    if (loanDate && returnDate && returnDate <= loanDate) {
      return { returnDateInvalid: true };
    }
    return null;
  }

  onSubmit() {
    this.submitted = true;
    if (this.loanForm.invalid) return;

    // Habilitar campo para incluir su valor en el formData
    this.loanForm.get('dueDate')?.enable();
    const formData = this.loanForm.value;
    
    this.loanService.createLoan(formData).subscribe({
      next: () => this.router.navigate(['/loans']),
      error: (error) => console.error('Error:', error)
    });
  }

  get f() {
    return this.loanForm.controls;
  }
}