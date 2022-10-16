import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book';
import { BookService } from '../book.service';

import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[]=[];

  constructor(
    private route: ActivatedRoute,
    private bookService: BookService

  ) { }

  ngOnInit(): void {
    this.getBooksByAuthor();
  }

  getBooksByAuthor() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.bookService.getBooksByAuthor(id)
      .subscribe(
        books =>  {this.books = books}
      );
  }
}
