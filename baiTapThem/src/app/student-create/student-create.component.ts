import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {studentslist} from "../dao/listStudent";

@Component({
  selector: 'app-student-create',
  templateUrl: './student-create.component.html',
  styleUrls: ['./student-create.component.css']
})
export class StudentCreateComponent implements OnInit {
  createStudent: FormGroup;

  constructor(private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.createStudent = this.fb.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      age: ['', Validators.required],
      avatar: ['', Validators.required]
    })
  }
students =studentslist;
  onSubmit() {
    console.log(this.createStudent.value);
    studentslist.push(this.createStudent.value);
  }
}
