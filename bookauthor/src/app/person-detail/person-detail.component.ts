import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Person } from '../model/person';
import { PersonService } from '../person.service';

@Component({
  selector: 'app-person-detail',
  templateUrl: './person-detail.component.html',
  styleUrls: ['./person-detail.component.css']
})
export class PersonDetailComponent implements OnInit {

  person?:Person;

  constructor(
    private route: ActivatedRoute,
    private location: Location,
    private personService: PersonService
    ) { }

  ngOnInit(): void {
    this.getPerson();
  }

  getPerson() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.personService.getPerson(id)
      .subscribe(person =>  this.person = person);
  }

  goBack(): void {
    this.location.back();
  }

}
