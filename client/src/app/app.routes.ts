import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { NgModule } from '@angular/core';
import { LoanListComponent } from './loan-list/loan-list.component';
import { BookFormComponent } from './book-form/book-form.component';
import { LoanFormComponent } from './loan-form/loan-form.component';

export const routes: Routes = [
    { path: "books", component: BookListComponent },
    { path: "create-book", component: BookFormComponent },
    { path: "edit-book/:id", component: BookFormComponent },
    { path: "loans", component: LoanListComponent },
    { path: "create-loan", component: LoanFormComponent },
    { path: "", redirectTo: "books", pathMatch: "full" }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }