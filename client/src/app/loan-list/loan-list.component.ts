import { Component, inject } from '@angular/core';
import { LoanService } from '../services/loan.service';
import { Router } from '@angular/router';
import { Loan } from '../models/loan.interface';

@Component({
  selector: 'app-loan-list',
  standalone: true,
  imports: [],
  templateUrl: './loan-list.component.html',
  styleUrl: './loan-list.component.css'
})
export class LoanListComponent {
  loanService = inject(LoanService)
  router = inject(Router)
  loans: Loan[] = []

  ngOnInit() {
    this.loanService
      .getLoans()
      .subscribe((data) => { this.loans = data })
  }

  goToCreate() {
    alert("Método no implementado")
  }

  returnLoan(id: number) {
    if (confirm("¿Estás seguro de regresar este libro?")) {
      this.loanService.returnLoan(id)
        .subscribe(() => {
          this.loans = this.loans.filter((loan) => loan.id != id)
        })
    }
  }
}
