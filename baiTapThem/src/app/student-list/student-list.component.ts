import {Component, Input, OnInit} from '@angular/core';
import {studentslist} from "../dao/listStudent";

// import any = jasmine.any;

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  students = studentslist;

  constructor() {
  }

  student1: any='';

  ngOnInit(): void {
  }

  ids: number;

  getstudent(id: string) {
    this.ids = Number(id);
   this.student1=this.students.find(element => element.id == this.ids);
  }
}
