import {Component, Input, OnInit} from '@angular/core';
export interface IStudent {
  id: number,
  name: string,
  age: number,
  avatar: string
}

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.css']
})
export class StudentInformationComponent implements OnInit {

  @Input()
  student:any='';

  constructor() { }

  ngOnInit(): void {
    console.log(this.student)
  }

}
