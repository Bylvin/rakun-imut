import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PersonsComponent } from './persons/persons.component';
import { BooksComponent } from "./books/books.component";
import { DashboardComponent } from './dashboard/dashboard.component';
import { PersonDetailComponent } from './person-detail/person-detail.component';
import { BookDetailComponent } from './book-detail/book-detail.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'persons', component: PersonsComponent },
  { path: 'books/author/:id', component: BooksComponent },
  { path: 'persons/:id', component: PersonDetailComponent },
  { path: 'books/:id', component: BookDetailComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }