import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Person } from './model/person';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  personsUrl = 'http://localhost:8080/persons'
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }  

  constructor(
    private http: HttpClient
  ) { }

  // Show All Person
  getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(this.personsUrl)
  
    .pipe(
      catchError((error: any): Observable<Person[]> => {
        console.log(error);
        return of([] as Person[]);
      })
    );
  }

  // Show Person By Id
  getPerson(id: number): Observable<Person> {
    return this.http.get<Person>(this.personsUrl+'/'+id)

    .pipe(
      catchError((error: any): Observable<Person> =>{
        console.log(error);
        return of({} as Person);
      })
    );
  }

  // Update Person By Id
  updatePerson(person: Person): Observable<any> {
    return this.http.put<any>(this.personsUrl+'/'+person.id,
        person, this.httpOptions)

    .pipe(
      catchError((error: any): Observable<any> =>{
        console.log(error);
        return of({} as any);
      })
    );
  }
}
