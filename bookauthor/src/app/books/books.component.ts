import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../book.service';
import { PersonService } from "../person.service";
import { Location } from '@angular/common';

import { ActivatedRoute } from '@angular/router';
import { Person } from '../model/person';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[]=[];
  person?: Person;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private bookService: BookService,
    private personService: PersonService
  ) { }

  ngOnInit(): void {
    this.getBooksByAuthor();
    this.getPerson();
  }

  getPerson(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.personService.getPerson(id)
    .subscribe(person => this.person = person);
  }

  getBooksByAuthor() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.bookService.getBooksByAuthor(id)
      .subscribe(
        books =>  {this.books = books}
      );
  }

  goBack(): void {
    this.location.back();
  }
}
