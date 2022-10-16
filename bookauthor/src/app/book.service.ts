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
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


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

  updatePerson(person: Person): Observable<any> {
    return this.http.put<any>(this.booksUrl+'/'+person.id,
        person, this.httpOptions)

    .pipe(
      catchError((error: any): Observable<any> =>{
        console.log(error);
        return of({} as any);
      })
    );
  }
  
}
