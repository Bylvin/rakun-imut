import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-persons',
  templateUrl: './persons.component.html',
  styleUrls: ['./persons.component.css']
})
export class PersonsComponent implements OnInit {

  persons: Person[]=[];

  constructor(
    private personService: PersonService
  ) { }

  ngOnInit(): void {
    this.getPersons();
  }

  getPersons(): void {
    this.personService.getPersons()
      .subscribe(persons =>  this.persons = persons);
  }
}
