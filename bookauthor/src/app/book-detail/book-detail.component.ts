import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Book } from '../model/book';
import { BookService } from '../book.service';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  book?:Book;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private bookService: BookService
  ) { }

  ngOnInit(): void {
    this.getBook();
  }

  localizer(text:Number):String{
    return text.toLocaleString();
  }

  getBook() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.bookService.getBook(id)
      .subscribe(book =>  this.book = book);
  }

  goBack(): void {
    this.location.back();
  }

  changePrice(price:any){
    if(!this.book){
      return;
    }
    this.book.price = Number(this.localizer(price));
    this.bookService.updatePrice(this.book).subscribe(()=>{});
  }
}
