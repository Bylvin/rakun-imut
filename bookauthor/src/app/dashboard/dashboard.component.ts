import { Component, OnInit } from '@angular/core';
import { Person } from '../model/person';
import { PERSONS } from '../dummy-persons';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  persons: Person[] = [];

  constructor() { }

  ngOnInit(): void {
    this.persons = PERSONS;
  }

}
