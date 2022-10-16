import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Book } from './model/book';
import { Person } from './model/person';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  booksUrl = 'http://localhost:8080/books'

  constructor(
    private http: HttpClient
  ) { }

  // Show All Book
  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl)
  
    .pipe(
      catchError((error: any): Observable<Book[]> => {
        console.log(error);
        return of([] as Book[]);
      })
    );
  }

  // Show Book By Id
  getBook(id: number): Observable<Book> {
    return this.http.get<Book>(this.booksUrl+'/'+id)

    .pipe(
      catchError((error: any): Observable<Book> =>{
        console.log(error);
        return of({} as Book);
      })
    );
  }

  // Show Book By Author
  getBooksByAuthor(id: number): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl+'/author'+'/'+id)

    .pipe(
      catchError((error: any): Observable<Book[]> => {
        console.log(error);
        return of([] as Book[]);
      })
    );
  }
}
